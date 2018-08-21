package com.wipro.feedapp.presenter;

import android.os.Build;
import android.util.Log;


import com.wipro.feedapp.view.MainContract;
import com.wipro.feedapp.model.FeedsList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bhushan on 07/8/18.
 */

public class GetFeedsInteractorImpl implements MainContract.GetFeedsInteractor {

    @Override
    public void getFeedsArrayList(final OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        GetFeedsDataService service = RetrofitInstance.getRetrofitInstance().create(GetFeedsDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<FeedsList> call = service.getFeedList();

        /**Log the URL called*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            Log.wtf("URL Called", call.request().url() + "");
        }

        call.enqueue(new Callback<FeedsList>() {
            @Override
            public void onResponse(Call<FeedsList> call, Response<FeedsList> response) {
                onFinishedListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<FeedsList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
