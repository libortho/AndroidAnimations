package com.vecoder.demo.animations;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.vecoder.demo.animations.bluetooth.BluetoothActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by velibor.gacina on 5/25/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<BluetoothActivity> mActivityRule = new ActivityTestRule(BluetoothActivity.class);

    @Test
    public void listGoesOverTheFold() {
        onView(withText("Hello Bluetooth")).check(matches(isDisplayed()));
    }
}