package com.pouyaheydari.appupdater.compose.ui.components

import android.Manifest
import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.pouyaheydari.appupdater.core.R as coreR

internal class DividerComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        val instrumentation = getInstrumentation()
        val packageName = instrumentation.context.packageName
        val permission = Manifest.permission.POST_NOTIFICATIONS
        instrumentation.uiAutomation.grantRuntimePermission(packageName, permission)
    }

    @Test
    fun test_orTextIsDisplayed() {
        val context: Context = getInstrumentation().targetContext

        composeTestRule.setContent {
            DividerComponent()
        }

        composeTestRule
            .onNodeWithText(context.resources.getString(coreR.string.appupdater_or))
            .assertIsDisplayed()
    }
}
