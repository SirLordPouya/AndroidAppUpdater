package com.pouyaheydari.appupdater.compose

import android.graphics.Typeface
import android.util.Log
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pouyaheydari.appupdater.compose.pojo.UpdaterDialogContent
import com.pouyaheydari.appupdater.compose.pojo.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.DialogHeaderComponent
import com.pouyaheydari.appupdater.compose.ui.DirectDownloadLinkComponent
import com.pouyaheydari.appupdater.compose.ui.DividerComponent
import com.pouyaheydari.appupdater.compose.ui.SquareStoreItemComponent
import com.pouyaheydari.appupdater.compose.ui.UpdateInProgressDialogComponent
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.compose.utils.getActivity
import com.pouyaheydari.appupdater.compose.utils.isDarkThemeSelected
import com.pouyaheydari.appupdater.compose.utils.storeList
import com.pouyaheydari.appupdater.core.pojo.DialogStates
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme
import com.pouyaheydari.appupdater.core.utils.TAG
import com.pouyaheydari.appupdater.core.utils.getApk
import com.pouyaheydari.appupdater.core.utils.shouldShowStoresDivider
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * Shows the compose dialog
 *
 * @param dialogTitle title of the update dialog
 * @param dialogDescription description of the update dialog
 * @param storeList list of Stores and Direct links to be shown to the user in the update dialog
 * @param onDismissRequested gets invoked when the user requests to dismiss the dialog
 * @param typeface Typeface to customize the font style if needed
 * @param theme theme of the dialog
 *
 */

@Deprecated(
    message = "This function is deprecated and will be removed in the next version. Use getInstance with UpdaterDialogData input parameter instead.",
    replaceWith = ReplaceWith("this.AndroidAppUpdater(UpdaterDialogData())", "com.pouyaheydari.appupdater.compose.pojo.UpdaterDialogData"),
)
@Composable
fun AndroidAppUpdater(
    dialogTitle: String = "",
    dialogDescription: String = "",
    storeList: List<StoreListItem> = listOf(),
    onDismissRequested: () -> Unit = {},
    typeface: Typeface? = null,
    theme: Theme = Theme.SYSTEM_DEFAULT,
) {
    AndroidAppUpdater(
        UpdaterDialogData(
            dialogTitle = dialogTitle,
            dialogDescription = dialogDescription,
            storeList = storeList,
            onDismissRequested = onDismissRequested,
            typeface = typeface,
            theme = theme,
        ),
    )
}

/**
 * Shows the compose dialog
 *
 * @param dialogData Data to be shown in the dialog
 */
@Composable
fun AndroidAppUpdater(dialogData: UpdaterDialogData) {
    val viewModel: AndroidAppUpdaterViewModel = viewModel()
    val activity = LocalContext.current.getActivity()

    with(dialogData) {
        AndroidAppUpdaterTheme(darkTheme = isDarkThemeSelected(theme)) {
            Dialog(onDismissRequest = { onDismissRequested() }) {
                val (directDownloadItems, storeItems) = storeList.partition { it.store == Store.DIRECT_URL }

                DialogContent(
                    UpdaterDialogContent(
                        dialogTitle = dialogTitle,
                        dialogDescription = dialogDescription,
                        directDownloadList = directDownloadItems,
                        storeList = storeItems,
                        typeface = typeface,
                        onClickListener = viewModel::onListListener,
                        shouldShowDividers = shouldShowStoresDivider(directDownloadItems, storeItems),
                    ),
                )
            }

            when (val value = viewModel.screenState.collectAsState().value) {
                is DialogStates.DownloadApk -> {
                    if (activity == null) {
                        Log.e(TAG, "Provided activity is null. Skipping downloading the apk")
                    } else {
                        getApk(value.apkUrl, activity)
                    }
                }

                DialogStates.HideUpdateInProgress -> {}
                is DialogStates.OpenStore -> {
                    value.store?.showStore(activity)
                }

                DialogStates.ShowUpdateInProgress -> UpdateInProgressDialogComponent()
            }
        }
    }
}

@Composable
private fun DialogContent(dialogContent: UpdaterDialogContent) {
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
                item(span = { GridItemSpan(maxLineSpan) }) { DialogHeaderComponent(dialogTitle, dialogDescription, typeface) }
                directDownloadList.forEach {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        DirectDownloadLinkComponent(it, onClickListener)
                    }
                }
                if (shouldShowDividers) {
                    item(span = { GridItemSpan(maxLineSpan) }) { DividerComponent() }
                }

                storeList.forEach {
                    item(span = { if (storeList.size > 1) GridItemSpan(1) else GridItemSpan(maxLineSpan) }) { SquareStoreItemComponent(it, onClickListener) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LightPreview() {
    AndroidAppUpdater(
        UpdaterDialogData(
            dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
            dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
            storeList = storeList,
            theme = Theme.LIGHT,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun LightPreviewSingleStoreItem() {
    AndroidAppUpdater(
        UpdaterDialogData(
            dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
            dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
            storeList = storeList.subList(2, 3),
            theme = Theme.LIGHT,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun LightPreviewSingleDirectLinkItem() {
    AndroidAppUpdater(
        UpdaterDialogData(
            dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
            dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
            storeList = storeList.subList(0, 1),
            theme = Theme.LIGHT,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun DarkPreview() {
    AndroidAppUpdater(
        UpdaterDialogData(
            dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
            dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
            storeList = storeList,
            theme = Theme.DARK,
        ),
    )
}
