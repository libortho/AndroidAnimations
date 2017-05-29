package com.vecoder.demo.animations;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.vecoder.demo.animations.imdig.ScrollViewActivity;
import com.vecoder.demo.animations.locators.ScrollViewPageLocators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by velibor.gacina on 5/26/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleScrollActTest extends BaseTestCase {

    @Rule
    public ActivityTestRule<ScrollViewActivity> mActivityRule = new ActivityTestRule(ScrollViewActivity.class);

    @Test
    public void pass_If_Everything_Is_Displayed() {
        assert_something_displayed(ScrollViewPageLocators.page_image);
        assert_matches_text(ScrollViewPageLocators.page_title, "Daft Punk");
        assert_something_displayed(ScrollViewPageLocators.demo_label);
    }
}
