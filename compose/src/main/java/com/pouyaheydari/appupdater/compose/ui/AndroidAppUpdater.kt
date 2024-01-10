package com.pouyaheydari.appupdater.compose.ui

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pouyaheydari.appupdater.compose.ui.components.DialogHeaderComponent
import com.pouyaheydari.appupdater.compose.ui.components.DirectDownloadLinkComponent
import com.pouyaheydari.appupdater.compose.ui.components.DividerComponent
import com.pouyaheydari.appupdater.compose.ui.components.SquareStoreItemComponent
import com.pouyaheydari.appupdater.compose.ui.components.UpdateInProgressDialogComponent
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenIntents
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.compose.utils.getActivity
import com.pouyaheydari.appupdater.compose.utils.getApkIfActivityIsNotNull
import com.pouyaheydari.appupdater.compose.utils.isDarkThemeSelected
import com.pouyaheydari.appupdater.compose.utils.storeList
import com.pouyaheydari.appupdater.core.pojo.Theme
import com.pouyaheydari.appupdater.core.stores.Stores
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * Shows the compose dialog
 *
 * @param dialogData Data to be shown in the dialog
 */
@Composable
fun AndroidAppUpdater(dialogData: UpdaterDialogData) {
    val viewModel: AndroidAppUpdaterViewModel = viewModel(factory = AndroidAppUpdaterViewModelFactory(dialogData))
    val state = viewModel.uiState.value

    AndroidAppUpdaterTheme(darkTheme = isDarkThemeSelected(dialogData.theme)) {
        if (state.shouldShowDialog) {
            AppUpdaterDialog(state.dialogContent, viewModel::handleIntent, typeface = dialogData.typeface)
        }
        if (state.shouldShowUpdateInProgress) {
            UpdateInProgressDialogComponent()
        }

        SetupStoreOpener(state.selectedStore, state.shouldOpenStore) {
            viewModel.handleIntent(DialogScreenIntents.OnStoreOpened)
        }
        SetupDirectApkDownload(state.downloadUrl, state.shouldStartAPKDownload)
    }
}

@Composable
private fun SetupDirectApkDownload(url: String, shouldStartAPKDownload: Boolean) {
    val activity = LocalContext.current.getActivity()

    LaunchedEffect(key1 = url) {
        if (shouldStartAPKDownload) {
            getApkIfActivityIsNotNull(activity, url)
        }
    }
}

@Composable
private fun SetupStoreOpener(store: Stores?, shouldOpenStore: Boolean, onStoreOpenedListener: () -> Unit) {
    val activity = LocalContext.current.getActivity()

    LaunchedEffect(key1 = store) {
        if (shouldOpenStore) {
            store?.showStore(activity)
        }
        onStoreOpenedListener()
    }
}

@Composable
private fun AppUpdaterDialog(dialogContent: UpdaterDialogUIData, onClickListener: (DialogScreenIntents) -> Unit, typeface: Typeface?) {
    Dialog(onDismissRequest = { dialogContent.onDismissRequested() }) {
        DialogContent(dialogContent, onClickListener, typeface)
    }
}

@Composable
private fun DialogContent(dialogContent: UpdaterDialogUIData, onClickListener: (DialogScreenIntents) -> Unit, typeface: Typeface?) {
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
                    DialogHeaderComponent(dialogHeader, typeface)
                }
                directDownloadList.forEach {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        DirectDownloadLinkComponent(it) {
                            onClickListener(DialogScreenIntents.OnDirectLinkClicked(it))
                        }
                    }
                }
                if (shouldShowDividers) {
                    item(span = { GridItemSpan(maxLineSpan) }) { DividerComponent() }
                }

                storeList.forEach {
                    item(span = { getStoreListGridItemSpan(storeList.size, maxLineSpan) }) {
                        SquareStoreItemComponent(it) {
                            onClickListener(DialogScreenIntents.OnStoreClicked(it))
                        }
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
private fun LightPreview() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
                dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
                storeList = storeList,
                theme = Theme.LIGHT,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LightPreviewSingleStoreItem() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
                dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
                storeList = storeList.subList(2, 3),
                theme = Theme.LIGHT,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LightPreviewSingleDirectLinkItem() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
                dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
                storeList = storeList.subList(0, 1),
                theme = Theme.LIGHT,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DarkPreview() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
                dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
                storeList = storeList,
                theme = Theme.DARK,
            ),
        )
    }
}
