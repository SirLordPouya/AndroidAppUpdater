package com.pouyaheydari.appupdater.compose.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenIntents
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenState
import com.pouyaheydari.appupdater.compose.ui.models.ErrorWhileOpeningStore
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.R
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import com.pouyaheydari.appupdater.directdownload.R as directDownloadR

@RunWith(RobolectricTestRunner::class)
internal class AndroidAppUpdaterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel: AndroidAppUpdaterViewModel = mock()

    @Test
    fun `test happy path`() {
        val dialogData = UpdaterDialogData()
        val onDismissRequested: () -> Unit = mock()
        val onStoreClickListener: (StoreListItem) -> Unit = mock()
        val onDirectLinkClickListener: (DirectDownloadListItem) -> Unit = mock()
        val uiState = DialogScreenState(
            shouldShowDialog = true,
            dialogContent = getUpdaterDialogData(
                onDismissRequested = onDismissRequested,
                onStoreClickListener = onStoreClickListener,
                onDirectLinkClickListener = onDirectLinkClickListener
            ),
            shouldShowUpdateInProgress = false,
            errorWhileOpeningStore = ErrorWhileOpeningStore(),
            selectedStore = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""),
            shouldOpenStore = false,
            downloadUrl = "",
            shouldStartAPKDownload = false
        )
        whenever(viewModel.uiState).thenReturn(MutableStateFlow(uiState))

        composeTestRule.setContent {
            AndroidAppUpdaterTheme {
                AndroidAppUpdaterScreen(dialogData, viewModel)
            }
        }

        composeTestRule.onNodeWithText("Title").assertExists()
        composeTestRule.onNodeWithText("Description").assertExists()
        composeTestRule.onNodeWithText("DirectDownload").assertExists()
        composeTestRule.onNodeWithText("GooglePlay").assertExists()
        composeTestRule.onNodeWithTag(R.drawable.appupdater_ic_google_play.toString()).assertExists()
        composeTestRule.onNodeWithText("GooglePlay").performClick()
        composeTestRule.onNodeWithText("DirectDownload").performClick()

        verify(onStoreClickListener).invoke(any())
        verify(onDirectLinkClickListener).invoke(any())
    }

    @Test
    fun `test whenever shouldShowDialog is false then the dialog is not displayed`() {
        val dialogData = UpdaterDialogData()
        val uiState = DialogScreenState(
            shouldShowDialog = false,
            dialogContent = getUpdaterDialogData(),
            shouldShowUpdateInProgress = false,
            errorWhileOpeningStore = ErrorWhileOpeningStore(),
            selectedStore = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""),
            shouldOpenStore = false,
            downloadUrl = "",
            shouldStartAPKDownload = false
        )
        whenever(viewModel.uiState).thenReturn(MutableStateFlow(uiState))

        composeTestRule.setContent {
            AndroidAppUpdaterTheme {
                AndroidAppUpdaterScreen(dialogData, viewModel)
            }
        }

        composeTestRule.onNodeWithText("Title").assertDoesNotExist()
        composeTestRule.onNodeWithText("Description").assertDoesNotExist()
    }

    @Test
    fun `test whenever shouldShowUpdateInProgress is true then the update in progress dialog is shown`() {
        val dialogData = UpdaterDialogData()
        val uiState = DialogScreenState(
            shouldShowDialog = false,
            dialogContent = getUpdaterDialogData(),
            shouldShowUpdateInProgress = true,
            errorWhileOpeningStore = ErrorWhileOpeningStore(),
            selectedStore = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""),
            shouldOpenStore = false,
            downloadUrl = "",
            shouldStartAPKDownload = false
        )
        whenever(viewModel.uiState).thenReturn(MutableStateFlow(uiState))

        composeTestRule.setContent {
            AndroidAppUpdaterTheme {
                AndroidAppUpdaterScreen(dialogData, viewModel)
            }
        }

        val context = RuntimeEnvironment.getApplication().applicationContext
        composeTestRule.onNodeWithText(context.getString(directDownloadR.string.appupdater_please_wait)).assertExists()
        composeTestRule.onNodeWithText(context.getString(directDownloadR.string.appupdater_downloading_new_version)).assertExists()
    }

    @Test
    fun `test whenever an error happens then the appropriate callback is called`() {
        val errorCallback: (String) -> Unit = mock()
        val dialogData = UpdaterDialogData(errorWhileOpeningStoreCallback = errorCallback)
        val uiState = DialogScreenState(
            shouldShowDialog = true,
            dialogContent = getUpdaterDialogData(),
            shouldShowUpdateInProgress = false,
            errorWhileOpeningStore = ErrorWhileOpeningStore(shouldNotifyCaller = true, storeName = "GooglePlay"),
            selectedStore = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""),
            shouldOpenStore = false,
            downloadUrl = "",
            shouldStartAPKDownload = false
        )
        whenever(viewModel.uiState).thenReturn(MutableStateFlow(uiState))

        composeTestRule.setContent {
            AndroidAppUpdaterTheme {
                AndroidAppUpdaterScreen(dialogData, viewModel)
            }
        }

        verify(errorCallback).invoke(any())
        verify(viewModel).handleIntent(DialogScreenIntents.OnErrorCallbackExecuted)
    }

    private fun getUpdaterDialogData(
        onDismissRequested: () -> Unit = {},
        onStoreClickListener: (StoreListItem) -> Unit = {},
        onDirectLinkClickListener: (DirectDownloadListItem) -> Unit = {},
    ) = UpdaterDialogUIData(
        dialogHeader = DialogHeaderModel(
            dialogTitle = "Title",
            dialogDescription = "Description",
            dialogIcon = R.drawable.appupdater_ic_google_play
        ),
        dividerText = "Divider",
        directDownloadList = listOf(DirectDownloadListItem(title = "DirectDownload", url = "")),
        storeList = listOf(StoreListItem(store = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""), title = "GooglePlay", icon = R.drawable.appupdater_ic_google_play)),
        shouldShowDividers = true,
        onDismissRequested = onDismissRequested,
        onStoreClickListener = onStoreClickListener,
        onDirectLinkClickListener = onDirectLinkClickListener
    )
}
