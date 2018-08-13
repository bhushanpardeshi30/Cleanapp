package com.wipro.feedapp;

import android.content.pm.ActivityInfo;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.wipro.feedapp.base.AbstractTest;
import com.wipro.feedapp.main_activity.MainActivity;
import com.wipro.feedapp.main_activity.MainContract;
import com.wipro.feedapp.main_activity.MainPresenterImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends AbstractTest{


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testFeedList(){
    }




}
