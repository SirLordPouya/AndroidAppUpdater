package com.pouyaheydari.appupdater.compose.ui.components

import android.Manifest
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

class DirectDownloadLinkComponentTest {
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
