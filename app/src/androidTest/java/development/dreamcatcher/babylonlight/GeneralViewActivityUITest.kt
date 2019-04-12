package development.dreamcatcher.babylonlight

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import development.dreamcatcher.babylonlight.activities.GeneralViewActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

@LargeTest
class GeneralViewActivityUITest {

    @get:Rule
    val activityRule = ActivityTestRule(GeneralViewActivity::class.java)

    @Test fun loadingBadgeIsDisplayed() {
        onView(withId(R.id.loading_container)).check(ViewAssertions.matches(isDisplayed()))
    }
}