package com.vecoder.demo.animations.locators;

import android.view.View;

import com.vecoder.demo.animations.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by velibor.gacina on 5/26/2017.
 */

public class ScrollViewPageLocators {

    public static Matcher<View> demo_label = withId(R.id.iv_simple_caller_image);

    public static Matcher<View> page_image = withId(R.id.scroll_page_image);

    public static Matcher<View> page_title = withId(R.id.scoll_page_title);

    public static Matcher<View> page_ad = withId(R.id.ad_view);

}
