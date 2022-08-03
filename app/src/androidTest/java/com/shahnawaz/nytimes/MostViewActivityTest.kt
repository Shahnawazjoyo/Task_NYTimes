package com.shahnawaz.nytimes

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResourceRule
import com.shahnawaz.nytimes.util.MostViewArticleTest
import com.shahnawaz.nytimes.view.ArticleViewHolder
import com.shahnawaz.nytimes.view.MostViewActivity
import junit.framework.Assert.assertEquals

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
class MostViewActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MostViewActivity::class.java)

    @get: Rule
    val espressoIdlingResoureRule = EspressoIdlingResourceRule()
    val LIST_ITEM_IN_TEST = 0


    val MostViewArticle = MostViewArticleTest.resultList[LIST_ITEM_IN_TEST]
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.shahnawaz.nytimes", appContext.packageName)
    }

    @Test
    fun mostViewArtilceListAppLaunch() {
        Espresso.onView(withId(R.id.article_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    
    @Test fun listMostViewArticle() {
        onView(withId(R.id.article_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ArticleViewHolder>(
                    LIST_ITEM_IN_TEST,
                    ViewActions.click()
                )
            )

         //Confirm nav to DetailFragment and display title
        onView(withId(R.id.titleTxtView)).check(matches(withText(MostViewArticle.title)))

        Espresso.pressBack()

         //Confirm MovieListFragment in view
        onView(withId(R.id.article_list)).check(matches(isDisplayed()))


    }



}