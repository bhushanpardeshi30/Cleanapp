package com.wipro.feedapp.main_activity;


import com.wipro.feedapp.model.FeedsList;


/**
 * Created by Bhushan on 07/8/18.
 */

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetFeedsInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetFeedsInteractor getFeedsInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetFeedsInteractor getFeedsInteractor) {
        this.mainView = mainView;
        this.getFeedsInteractor = getFeedsInteractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getFeedsInteractor.getFeedsArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getFeedsInteractor.getFeedsArrayList(this);
    }


    @Override
    public void onFinished(FeedsList feedsArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(feedsArrayList);
            mainView.hideProgress();
        }
    }



    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }

    @Override
    public void attach(MainContract.MainView view) {
        this.mainView=mainView;
    }

    @Override
    public void detach() {
        this.mainView=null;

    }
}
