package com.shahnawaz.nytimes

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResourceRule
import com.shahnawaz.nytimes.view.MovtViewDetailScreen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.runners.MethodSorters

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4ClassRunner::class)
class MostViewDetailScreenTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MovtViewDetailScreen::class.java)

    @get: Rule
    val espressoIdlingResoureRule = EspressoIdlingResourceRule()

    @Test
    fun mostViewArtilceListAppLaunch() {
        Espresso.onView(withId(R.id.webView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }





}