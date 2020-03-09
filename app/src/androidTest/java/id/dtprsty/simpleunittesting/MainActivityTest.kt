package id.dtprsty.simpleunittesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"

    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"

    private val emptyInput = ""
    private val fieldEmpty = "Field can not empty"

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun getCircumference(){
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateCircumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateCircumference)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun getSurfaceArea() {
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateSurface)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateSurface)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummySurfaceArea)))
    }

    @Test
    fun getVolume() {
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateVolume)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateVolume)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyVolume)))
    }

    //Pengecekan untuk empty input
    @Test
    fun emptyInput() {
        // pengecekan input untuk length
        onView(withId(R.id.etLength)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etLength)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())

        // pengecekan input untuk width
        onView(withId(R.id.etWidth)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etWidth)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())

        // pengecekan input untuk height
        onView(withId(R.id.etHeight)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etHeight)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())
    }
}