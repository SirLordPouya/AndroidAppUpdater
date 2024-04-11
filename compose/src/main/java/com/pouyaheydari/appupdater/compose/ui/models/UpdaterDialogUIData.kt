package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem

internal data class UpdaterDialogUIData(
    val dialogHeader: DialogHeaderModel = DialogHeaderModel(),
    val directDownloadList: List<DirectDownloadListItem> = emptyList(),
    val storeList: List<StoreListItem> = emptyList(),
    val shouldShowDividers: Boolean = false,
    inline val onDismissRequested: () -> Unit = {},
)