package com.vecoder.demo.animations;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by velibor.gacina on 5/26/2017.
 */

public class BaseTestCase {

    static ViewInteraction assert_something_displayed(Matcher<View> elem) {
        ViewInteraction assertion;
        assertion = onView(elem).check(matches(isDisplayed()));
        return assertion;
    }

    static ViewInteraction assert_completely_displayed(Matcher<View> elem) {
        ViewInteraction assertion;
        assertion = onView(elem).check(matches(isCompletelyDisplayed()));
        return assertion;
    }

    static ViewInteraction assert_matches_text(Matcher<View> elem, String text) {
        ViewInteraction assertion;
        assertion = onView(elem).check(matches(withText(text)));
        return assertion;
    }

    static ViewInteraction assert_is_clickable(Matcher<View> elem) {
        ViewInteraction assertion;
        assertion = onView(elem).check(matches(isClickable()));
        return assertion;
    }


}
