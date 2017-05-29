package com.vecoder.demo.animations;

import android.support.test.rule.ActivityTestRule;

import com.vecoder.demo.animations.imdig.ScrollViewActivity;
import com.vecoder.demo.animations.locators.SimpleCallerLocators;
import com.vecoder.demo.animations.phone.SimpleCallerActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by velibor.gacina on 5/29/2017.
 */

public class SimpleCallerTest extends BaseTestCase {

    @Rule
    public ActivityTestRule<SimpleCallerActivity> mActivityRule = new ActivityTestRule(SimpleCallerActivity.class);

    @Test
    public void pass_If_Everything_Is_Displayed() {
        assert_completely_displayed(SimpleCallerLocators.image);
        assert_something_displayed(SimpleCallerLocators.paragraph1);
        assert_something_displayed(SimpleCallerLocators.paragraph2);
        //assert_something_displayed(SimpleCallerLocators.btnCall);
    }

    @Test
    public void validateIntentSentToPackage() {
        // User action that results in an external "phone" activity being launched.

        onView(SimpleCallerLocators.btnCall).perform(click());


        // Using a canned RecordedIntentMatcher to validate that an intent resolving
        // to the "phone" activity has been sent.
        //intended(toPackage("com.android.phone"));  needs mockito
    }

}


