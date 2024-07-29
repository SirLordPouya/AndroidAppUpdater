package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem

internal data class UpdaterDialogUIData(
    val dialogHeader: DialogHeaderModel = DialogHeaderModel(),
    val dividerText: String = "",
    val directDownloadList: List<DirectDownloadListItem> = emptyList(),
    val storeList: List<StoreListItem> = emptyList(),
    val shouldShowDividers: Boolean = false,
    val onDismissRequested: () -> Unit = {},
    val onStoreClickListener: (StoreListItem) -> Unit = {},
    val onDirectLinkClickListener: (DirectDownloadListItem) -> Unit = {},
)
