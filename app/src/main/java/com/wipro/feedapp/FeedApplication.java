package com.wipro.feedapp;

import android.app.Application;
import android.content.Context;

public class FeedApplication extends Application {
    private static FeedApplication sInstance;


    public static FeedApplication getInstance() {
        return sInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
