package com.wipro.feedapp.my_interface;


import com.wipro.feedapp.model.FeedsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetFeedsDataService {
    @GET(".")
    Call<FeedsList> getFeedList();

}