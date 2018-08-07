package com.wipro.feedapp;

import android.content.pm.ActivityInfo;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.LayoutInflater;

import com.wipro.feedapp.main_activity.MainActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);


    public void testOnCreate() throws Exception {
        MainActivity activity = rule.getActivity();


        //Check all the activity components
        assertNotNull(activity);

        //Check if the rights components are available on the screen
        assertNotNull(LayoutInflater.from(activity));
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //testOrientationPortrait();
        Thread.sleep(50);
        assertTrue(true);

    }

    public void testOrientationChange() throws Exception {
        MainActivity activity = rule.getActivity();

        assertNotNull(activity);
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Check if the rights components are available on the screen
        assertNotNull(LayoutInflater.from(activity));
        Thread.sleep(50);
        assertTrue(true);

        //testOrientationLandscape();
    }
}
