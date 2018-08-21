package com.wipro.feedapp.view;


import com.wipro.feedapp.model.FeedsList;
import com.wipro.feedapp.presenter.BasePresenter;

/**
 * Created by Bhushan on 07/8/18.
 */

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter extends BasePresenter<MainView>{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(FeedsList noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetFeedsInteractor {

        interface OnFinishedListener {
            void onFinished(FeedsList feedsArrayList);
            void onFailure(Throwable t);
        }

        void getFeedsArrayList(OnFinishedListener onFinishedListener);
    }
}
