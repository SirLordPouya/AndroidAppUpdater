package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class DividerComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_whenComponentIsCalled_thenCorrectTextIsDisplayed() {
        val dividerText = "Text"

        composeTestRule.setContent {
            DividerComponent(dividerText = dividerText)
        }

        composeTestRule.onNodeWithText(dividerText)
            .assertIsDisplayed()
            .assertTextEquals(dividerText)
    }
}
