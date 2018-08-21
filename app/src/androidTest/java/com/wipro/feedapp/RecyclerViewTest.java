package com.wipro.feedapp;

import android.test.ActivityInstrumentationTestCase2;

import com.wipro.feedapp.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.wipro.feedapp.TestUtils.withRecyclerView;

public class RecyclerViewTest extends ActivityInstrumentationTestCase2<MainActivity>
{
    public RecyclerViewTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {

        getActivity();
    }

    public void testItemClick() {

        onView(withRecyclerView(R.id.rcViewFeeds).atPosition(1)).perform(click());

        onView(withId(R.id.txt_feeds_title)).check(matches(isDisplayed()));

    }
}
