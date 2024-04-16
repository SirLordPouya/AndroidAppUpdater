package com.pouyaheydari.appupdater.compose.ui.components

import android.Manifest
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.verify
import com.pouyaheydari.appupdater.core.R as coreR

class SquareStoreItemComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val packageName = instrumentation.context.packageName
        val permission = Manifest.permission.POST_NOTIFICATIONS
        instrumentation.uiAutomation.grantRuntimePermission(packageName, permission)
    }

    @Test
    fun test_whenComponentIsCalled_thenCorrectTextIsBeingDisplayed() {
        val storeTitle = "Title"

        composeTestRule.setContent {
            SquareStoreItemComponent(title = storeTitle)
        }

        composeTestRule.onNodeWithText(storeTitle)
            .assertIsDisplayed()
            .assertTextEquals(storeTitle)
    }

    @Test
    fun test_whenComponentIsCalled_thenCorrectIconIsBeingDisplayed() {
        val storeIcon = coreR.drawable.appupdater_ic_google_play

        composeTestRule.setContent {
            SquareStoreItemComponent(icon = storeIcon)
        }

        composeTestRule.onNodeWithTag(storeIcon.toString(), useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun test_whenComponentIsCalled_andUserClickOnText_thenOnClickListenerIsCalled() {
        val clickListener: () -> Unit = Mockito.mock()

        composeTestRule.setContent {
            SquareStoreItemComponent(onClickListener = clickListener)
        }
        composeTestRule.onRoot().performClick()

        verify(clickListener).invoke()
    }
}
