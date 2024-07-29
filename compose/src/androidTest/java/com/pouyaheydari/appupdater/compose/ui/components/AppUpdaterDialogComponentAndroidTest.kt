package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.pouyaheydari.appupdater.compose.ComposeTestActivity
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class AppUpdaterDialogComponentAndroidTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeTestActivity>()

    @Test
    fun test_wheneverDialogIsDismissed_thenCorrectCallbackIsBeingCalled() {
        val onDismissRequest: () -> Unit = mock()
        val dialogContent = UpdaterDialogUIData(onDismissRequested = onDismissRequest)
        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        // https://issuetracker.google.com/issues/229759201?pli=1
        UiDevice.getInstance(getInstrumentation()).pressBack()

        verify(onDismissRequest).invoke()
    }
}
