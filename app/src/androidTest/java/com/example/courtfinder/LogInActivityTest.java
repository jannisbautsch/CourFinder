package com.example.courtfinder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LogInActivityTest {

    @Rule
    public IntentsTestRule<LogInActivity> activityTestRule =
            new IntentsTestRule<LogInActivity>(LogInActivity.class);

    @Test
    public void displayAddDeckButton() {
        onView(withId(R.id.email)).
                check(matches(isDisplayed()));
    }
}