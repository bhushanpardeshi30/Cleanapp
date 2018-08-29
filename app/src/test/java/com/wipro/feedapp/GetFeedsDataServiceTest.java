package com.wipro.feedapp;

import com.wipro.feedapp.model.FeedsList;
import com.wipro.feedapp.presenter.GetFeedsDataService;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;

public class GetFeedsDataServiceTest {



    @Test
    public void testApiResponse() {
        GetFeedsDataService mockedGetFeedsDataService = Mockito.mock(GetFeedsDataService.class);
        Call<FeedsList> mockedCall = Mockito.mock(Call.class);

        Mockito.when(mockedGetFeedsDataService.getFeedList()).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Callback<FeedsList> callback = invocation.getArgument(0);

                callback.onResponse(mockedCall, Response.success(new FeedsList()));
                // or callback.onResponse(mockedCall, Response.error(404. ...);
                // or callback.onFailure(mockedCall, new IOException());

                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));

        // inject mocked ApiInterface to your presenter
        // and then mock view and verify calls (and eventually use ArgumentCaptor to access call parameters)
    }

}
