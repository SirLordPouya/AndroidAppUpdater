package com.pouyaheydari.appupdater.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pouyaheydari.androidappupdater.store.domain.showAppInSelectedStore
import com.pouyaheydari.androidappupdater.store.model.ShowStoreModel
import com.pouyaheydari.androidappupdater.store.model.Theme
import com.pouyaheydari.appupdater.compose.ui.components.AppUpdaterDialog
import com.pouyaheydari.appupdater.compose.ui.components.UpdateInProgressDialogComponent
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenIntents
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.compose.utils.getActivity
import com.pouyaheydari.appupdater.compose.utils.getApkIfActivityIsNotNull
import com.pouyaheydari.appupdater.compose.utils.isDarkThemeSelected
import com.pouyaheydari.appupdater.compose.utils.previewDirectDownloadListData
import com.pouyaheydari.appupdater.compose.utils.previewStoreListData
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
            AppUpdaterDialog(
                dialogContent = state.dialogContent,
                onStoreClickListener = { viewModel.handleIntent(DialogScreenIntents.OnStoreClicked(it)) },
                onDirectLinkClickListener = { viewModel.handleIntent(DialogScreenIntents.OnDirectLinkClicked(it)) },
                typeface = dialogData.typeface,
            )
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
private fun SetupStoreOpener(store: ShowStoreModel, shouldOpenStore: Boolean, onStoreOpenedListener: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(key1 = store) {
        if (shouldOpenStore) {
            showAppInSelectedStore(context, store)
        }
        onStoreOpenedListener()
    }
}

@Preview(showBackground = true)
@Composable
private fun LightPreview() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
                dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
                storeList = previewDirectDownloadListData + previewStoreListData,
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
                storeList = previewStoreListData.subList(0, 1),
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
                storeList = previewDirectDownloadListData.subList(0, 1),
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
                storeList = previewDirectDownloadListData + previewStoreListData,
                theme = Theme.DARK,
            ),
        )
    }
}
