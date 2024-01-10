package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.pojo.StoreListItem

internal data class UpdaterDialogUIData(
    val dialogHeader: DialogHeaderModel = DialogHeaderModel(),
    val directDownloadList: List<StoreListItem> = emptyList(),
    val storeList: List<StoreListItem> = emptyList(),
    val shouldShowDividers: Boolean = false,
    inline val onDismissRequested: () -> Unit = {},
)
