package com.example.courtfinder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LogInActivityTest {

    @Rule
    public ActivityTestRule<LogInActivity> activityTestRule =
            new ActivityTestRule<>(LogInActivity.class, false, true);

    @Before
    public void setUp() throws Exception{
        Intents.init();
    }

    @Test
    public void displayEmailTextField() {
        onView(withId(R.id.email)).
                check(matches(isDisplayed()));
    }

    @Test
    public void displayPasswordTextField() {
        onView(withId(R.id.password)).
                check(matches(isDisplayed()));
    }

    @Test
    public void displayLoginButton() {
        onView(withId(R.id.loginb)).
                check(matches(isDisplayed()));
    }

    @Test
    public void canLogInAndStartsMainActivity() {
        onView(withId(R.id.email)).perform(click()).perform(typeText("hello@courtfinder.de"));
        onView(withId(R.id.password)).perform(click()).perform(typeText("password123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.email)).equals("hello@courtfinder.de");
        onView(withId(R.id.password)).equals("password123");

        onView(withId(R.id.loginb)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }

    @After
    public void tearDown() throws Exception{
        Intents.release();
    }


}