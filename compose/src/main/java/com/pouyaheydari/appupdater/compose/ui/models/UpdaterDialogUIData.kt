package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.pojo.StoreListItem

internal data class UpdaterDialogUIData(
    val dialogHeader: DialogHeaderModel,
    val directDownloadList: List<StoreListItem>,
    val storeList: List<StoreListItem>,
    val shouldShowDividers: Boolean,
    inline val onDismissRequested: () -> Unit = {},
)
