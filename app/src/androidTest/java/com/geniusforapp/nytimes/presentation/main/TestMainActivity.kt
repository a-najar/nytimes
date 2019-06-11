package com.geniusforapp.nytimes.presentation.main


import android.widget.AutoCompleteTextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.geniusforapp.nytimes.R
import com.geniusforapp.nytimes.presentation.main.adapters.holders.MainViewHolder
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * @name nytimes
 * Copyrights (c) 2019-06-11 Created By Ahmad Najar
 **/

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestMainActivity {


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun `click-item-at-first`() {
        Thread.sleep(5000)
        onView(withId(R.id.listItems))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MainViewHolder>(0, click()))
    }


    @Test
    fun `test-empty-list`() {
        assertEquals(activityRule.activity.mainAdapter.itemCount > 0, true)
    }

    @Test
    fun `test-menu-click-one`() {
        Espresso.openContextualActionModeOverflowMenu()
        onView(withText(R.string.actionOne))
            .perform(click())
    }

    @Test
    fun `test-menu-click-seven`() {
        Espresso.openContextualActionModeOverflowMenu()
        onView(withText(R.string.actionSeven))
            .perform(click())
    }


    @Test
    fun `test-menu-click-month`() {
        Espresso.openContextualActionModeOverflowMenu()
        onView(withText(R.string.actionSeven))
            .perform(click())
    }

    @Test
    fun `test-search-view-is-opening`() {
        onView(withId(R.id.searchView)).perform(click())
        onView(isAssignableFrom(AutoCompleteTextView::class.java)).perform(typeText("hello")).check(
            ViewAssertions.matches(withText(CoreMatchers.containsString("hello")))
        )

    }

}