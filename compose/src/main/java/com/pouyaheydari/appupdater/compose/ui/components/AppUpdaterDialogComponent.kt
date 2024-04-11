package com.pouyaheydari.appupdater.compose.ui.components

import android.graphics.Typeface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.compose.utils.previewDirectDownloadListData
import com.pouyaheydari.appupdater.compose.utils.previewStoreListData
import com.pouyaheydari.appupdater.core.R

@Composable
internal fun AppUpdaterDialog(
    dialogContent: UpdaterDialogUIData,
    onStoreClickListener: (StoreListItem) -> Unit = {},
    onDirectLinkClickListener: (DirectDownloadListItem) -> Unit = {},
    typeface: Typeface? = null,
) {
    Dialog(onDismissRequest = { dialogContent.onDismissRequested() }) {
        DialogContent(dialogContent, onStoreClickListener, onDirectLinkClickListener, typeface)
    }
}

@Composable
private fun DialogContent(
    dialogContent: UpdaterDialogUIData,
    onStoreClickListener: (StoreListItem) -> Unit,
    onDirectLinkClickListener: (DirectDownloadListItem) -> Unit,
    typeface: Typeface?,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            with(dialogContent) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    DialogHeaderComponent(content = dialogHeader, typeface = typeface)
                }
                directDownloadList.forEach {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        DirectDownloadLinkComponent(title = it.title) { onDirectLinkClickListener(it) }
                    }
                }
                if (shouldShowDividers) {
                    item(span = { GridItemSpan(maxLineSpan) }) { DividerComponent() }
                }

                storeList.forEach {
                    item(span = { getStoreListGridItemSpan(storeList.size, maxLineSpan) }) {
                        SquareStoreItemComponent(title = it.title, icon = it.icon) { onStoreClickListener(it) }
                    }
                }
            }
        }
    }
}

private fun getStoreListGridItemSpan(storeListSize: Int, maxLineSpan: Int) =
    if (storeListSize > 1) GridItemSpan(1) else GridItemSpan(maxLineSpan)

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        AppUpdaterDialog(
            dialogContent = UpdaterDialogUIData(
                dialogHeader = DialogHeaderModel(
                    dialogTitle = stringResource(id = R.string.appupdater_app_name),
                    dialogDescription = stringResource(id = R.string.appupdater_download_notification_desc),
                ),
                directDownloadList = previewDirectDownloadListData,
                storeList = previewStoreListData,
                shouldShowDividers = false,
                onDismissRequested = {},
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSingleStoreItem() {
    AndroidAppUpdaterTheme {
        AppUpdaterDialog(
            dialogContent = UpdaterDialogUIData(
                dialogHeader = DialogHeaderModel(
                    dialogTitle = stringResource(id = R.string.appupdater_app_name),
                    dialogDescription = stringResource(id = R.string.appupdater_download_notification_desc),
                ),
                directDownloadList = listOf(),
                storeList = previewStoreListData.subList(0, 1),
                shouldShowDividers = false,
                onDismissRequested = {},
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSingleDirectLinkItem() {
    AndroidAppUpdaterTheme {
        AppUpdaterDialog(
            dialogContent = UpdaterDialogUIData(
                dialogHeader = DialogHeaderModel(
                    dialogTitle = stringResource(id = R.string.appupdater_app_name),
                    dialogDescription = stringResource(id = R.string.appupdater_download_notification_desc),
                ),
                directDownloadList = previewDirectDownloadListData.subList(0, 1),
                storeList = listOf(),
                shouldShowDividers = false,
                onDismissRequested = {},
            ),
        )
    }
}