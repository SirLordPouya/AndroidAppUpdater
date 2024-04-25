package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner
import com.pouyaheydari.appupdater.store.R as storeR

@RunWith(RobolectricTestRunner::class)
internal class SquareStoreItemComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

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
        val storeIcon = storeR.drawable.appupdater_ic_google_play

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
