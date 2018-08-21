package com.wipro.feedapp.presenter;


import com.wipro.feedapp.model.FeedsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetFeedsDataService {
    @GET(".")
    Call<FeedsList> getFeedList();

}