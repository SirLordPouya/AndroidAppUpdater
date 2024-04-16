package com.pouyaheydari.appupdater.compose.ui.components

import android.Manifest
import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import com.pouyaheydari.appupdater.core.R as coreR

internal class DividerComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(Manifest.permission.POST_NOTIFICATIONS)

    @Test
    fun test_whenComponentIsCalled_thenCorrectTextIsDisplayed() {
        val context: Context = getInstrumentation().targetContext

        composeTestRule.setContent {
            DividerComponent()
        }

        composeTestRule.onNodeWithText(context.resources.getString(coreR.string.appupdater_or))
            .assertIsDisplayed()
            .assertTextEquals(context.resources.getString(coreR.string.appupdater_or))
    }
}
