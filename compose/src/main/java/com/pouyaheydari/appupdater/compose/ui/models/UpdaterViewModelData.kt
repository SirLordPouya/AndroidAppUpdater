package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.model.Theme
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem

internal data class UpdaterViewModelData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val dividerText: String = "",
    val storeList: List<StoreListItem> = listOf(),
    val directDownloadList: List<DirectDownloadListItem> = listOf(),
    val onDismissRequested: () -> Unit = {},
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
