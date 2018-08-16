package com.wipro.feedapp.main_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wipro.feedapp.R;
import com.wipro.feedapp.adapter.FeedsAdapter;
import com.wipro.feedapp.model.FeedsList;
import com.wipro.feedapp.model.Row;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private ProgressBar progressBar;
    private RecyclerView rcViewFeeds;

    private MainContract.presenter presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbarAndRecyclerView();
        initProgressBar();


        presenter = new MainPresenterImpl(this, new GetFeedsInteractorImpl());
        presenter.requestDataFromServer();

    }


    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initializeToolbarAndRecyclerView() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rcViewFeeds = findViewById(R.id.rcViewFeeds);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rcViewFeeds.setLayoutManager(layoutManager);


    }


    /**
     * Initializing progressbar programmatically
     * */
    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
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
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            presenter.onRefreshButtonClick();
        }

        return super.onOptionsItemSelected(item);
    }


}

