package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner
import com.pouyaheydari.appupdater.store.R as storeR

@RunWith(RobolectricTestRunner::class)
internal class AppUpdaterDialogComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `whenever component is called with dialogHeader, then items in the header are shown correctly`() {
        val dialogContent = UpdaterDialogUIData(
            dialogHeader = DialogHeaderModel(
                dialogTitle = "Title",
                dialogDescription = "Description",
                dialogIcon = storeR.drawable.appupdater_ic_google_play,
            ),
        )

        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(dialogContent.dialogHeader.dialogTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(dialogContent.dialogHeader.dialogDescription).assertIsDisplayed()
        composeTestRule.onNodeWithTag(dialogContent.dialogHeader.dialogIcon.toString()).assertIsDisplayed()
    }

    @Test
    fun `whenever component is called with directDownloadList, then items in direct download are shown correctly`() {
        val directDownloadItem = DirectDownloadListItem("DirectDownloadItem", "Url")
        val dialogContent = UpdaterDialogUIData(
            directDownloadList = listOf(directDownloadItem),
        )

        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(directDownloadItem.title).assertIsDisplayed()
    }

    @Test
    fun `whenever component is called with storeList, then items in direct download are shown correctly`() {
        val storeItem = StoreListItem(
            store = StoreFactory.getSamsungGalaxyStore(""),
            title = "Store",
            icon = storeR.drawable.appupdater_ic_galaxy_store,
        )

        val dialogContent = UpdaterDialogUIData(
            storeList = listOf(storeItem),
        )

        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(storeItem.title).assertIsDisplayed()
        composeTestRule.onNodeWithTag(storeItem.icon.toString(), useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun `whenever user clicks on store items, then correct callback is being called`() {
        val onStoreClickedListener: (StoreListItem) -> Unit = mock()
        val storeItem = StoreListItem(
            store = StoreFactory.getSamsungGalaxyStore(""),
            title = "Store",
            icon = storeR.drawable.appupdater_ic_galaxy_store,
        )
        val dialogContent = UpdaterDialogUIData(
            storeList = listOf(storeItem),
            onStoreClickListener = onStoreClickedListener,
        )
        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(storeItem.title).performClick()

        verify(onStoreClickedListener).invoke(storeItem)
    }

    @Test
    fun `whenever user clicks on direct download items, then correct callback is being called`() {
        val onDirectDownloadItemClicked: (DirectDownloadListItem) -> Unit = mock()
        val directDownloadItem = DirectDownloadListItem("DirectDownloadItem", "Url")
        val dialogContent = UpdaterDialogUIData(
            directDownloadList = listOf(directDownloadItem),
            onDirectLinkClickListener = onDirectDownloadItemClicked,
        )
        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(directDownloadItem.title).performClick()

        verify(onDirectDownloadItemClicked).invoke(directDownloadItem)
    }

    @Test
    fun `whenever component is called with divider true, then items in the header are shown correctly`() {
        val dividerText = "Or"
        val dialogContent = UpdaterDialogUIData(
            shouldShowDividers = true,
            dividerText = dividerText,
        )
        composeTestRule.setContent {
            AppUpdaterDialogComponent(dialogContent = dialogContent)
        }

        composeTestRule.onNodeWithText(dividerText).assertIsDisplayed()
    }
}
