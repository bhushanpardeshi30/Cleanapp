package com.wipro.feedapp.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.widget.Toast;

import com.wipro.feedapp.R;
import com.wipro.feedapp.presenter.adapter.FeedsAdapter;
import com.wipro.feedapp.model.FeedsList;
import com.wipro.feedapp.model.Row;
import com.wipro.feedapp.presenter.GetFeedsInteractorImpl;
import com.wipro.feedapp.presenter.MainPresenterImpl;
import com.wipro.feedapp.presenter.RecyclerItemClickListener;


public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private RecyclerView rcViewFeeds;
    SwipeRefreshLayout mSwipeRefreshLayout;

    private MainContract.presenter presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbarAndRecyclerView();


        presenter = new MainPresenterImpl(this, new GetFeedsInteractorImpl());
        presenter.requestDataFromServer();

    }


    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndRecyclerView() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);

        rcViewFeeds = findViewById(R.id.rcViewFeeds);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rcViewFeeds.setLayoutManager(layoutManager);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onRefreshButtonClick();
                hideProgress();
            }
        });
    }



    /**
     * RecyclerItem click event listener
     * */
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Row row) {

            Toast.makeText(MainActivity.this,
                    "Title: " + row.getTitle(),
                    Toast.LENGTH_LONG).show();

        }
    };


    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
    }


    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void setDataToRecyclerView(FeedsList feedsArrayList) {

        FeedsAdapter adapter = new FeedsAdapter(feedsArrayList , recyclerItemClickListener);
        rcViewFeeds.setAdapter(adapter);

        toolbar.setTitle(feedsArrayList.getTitle());

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                R.string.error_msg + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }



}

