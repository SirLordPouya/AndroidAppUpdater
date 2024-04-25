package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import com.pouyaheydari.appupdater.store.R as storeR

@RunWith(RobolectricTestRunner::class)
internal class DialogHeaderComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_whenComponentIsCalled_thenCorrectUiIsBeingDisplayed() {
        val dialogTitle = "Title"
        val dialogDescription = "Description"
        val dialogIcon = storeR.drawable.appupdater_ic_google_play
        composeTestRule.setContent {
            DialogHeaderComponent(
                content = DialogHeaderModel(
                    dialogTitle = dialogTitle,
                    dialogDescription = dialogDescription,
                    dialogIcon = dialogIcon,
                ),
            )
        }

        composeTestRule.onNodeWithText(dialogTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(dialogDescription).assertIsDisplayed()
        composeTestRule.onNodeWithTag(dialogIcon.toString()).assertIsDisplayed()
    }
}
