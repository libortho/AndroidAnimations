package com.vecoder.demo.animations.locators;

import android.view.View;

import com.vecoder.demo.animations.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by velibor.gacina on 5/29/2017.
 */

public class SimpleCallerLocators {

    public static Matcher<View> image = withId(R.id.iv_simple_caller_image);

    public static Matcher<View> paragraph1 = withId(R.id.tv_simple_caller_p1);

    public static Matcher<View> paragraph2 = withId(R.id.tv_simple_caller_p2);

    public static Matcher<View> btnCall = withId(R.id.btn_simple_caller_call);
}
