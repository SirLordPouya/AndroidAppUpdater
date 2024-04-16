package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DirectDownloadLinkComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_whenComponentIsCalled_thenCorrectTextIsBeingDisplayed() {
        val title = "Text"

        composeTestRule.setContent {
            DirectDownloadLinkComponent(title = title)
        }

        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun test_whenComponentIsCalled_andUserClickOnText_thenOnClickListenerIsCalled() {
        val title = "Text"
        val clickListener: () -> Unit = mock()

        composeTestRule.setContent {
            DirectDownloadLinkComponent(title = title, onClickListener = clickListener)
        }
        composeTestRule.onNodeWithText(title).performClick()

        verify(clickListener).invoke()
    }
}
