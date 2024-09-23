package com.example.mycv;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import com.example.mycv.view.HelpActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class HelpActivityTest {

    @Test
    public void testHourTextIsUpdated() throws InterruptedException {
        try (ActivityScenario<HelpActivity> scenario = ActivityScenario.launch(HelpActivity.class)) {

            onView(withId(R.id.hour_help))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

            Thread.sleep(1000);

            String expectedFormat = new SimpleDateFormat("HH:mm:ss", new Locale("pt", "BR"))
                    .format(Calendar.getInstance().getTime());

            onView(withId(R.id.hour_help)).check(ViewAssertions.matches(withText(expectedFormat)));
        }
    }
}
