package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class UpdateInProgressDialogComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_whenComponentIsCalled_andTheDialogMustBeVisible_thenCorrectNodesAreBeingShown() {
        val dialogTitle = "Title"
        val dialogDescription = "Description"
        composeTestRule.setContent {
            UpdateInProgressDialogComponent(
                isUpdateInProgress = true,
                dialogTitle = dialogTitle,
                dialogDescription = dialogDescription,
            )
        }

        composeTestRule.onNodeWithText(dialogTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(dialogDescription).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DIALOG_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun test_whenComponentIsCalled_andTheDialogMustBeInvisible_thenNoNodesAreShown() {
        val dialogTitle = "Title"
        val dialogDescription = "Description"
        composeTestRule.setContent {
            UpdateInProgressDialogComponent(
                isUpdateInProgress = false,
                dialogTitle = dialogTitle,
                dialogDescription = dialogDescription,
            )
        }

        composeTestRule.onNodeWithText(dialogTitle).assertDoesNotExist()
        composeTestRule.onNodeWithText(dialogDescription).assertDoesNotExist()
        composeTestRule.onNodeWithTag(DIALOG_TEST_TAG).assertDoesNotExist()
    }
}
