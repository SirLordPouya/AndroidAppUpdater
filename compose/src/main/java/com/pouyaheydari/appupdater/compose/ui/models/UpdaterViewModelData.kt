package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.core.model.Theme

internal data class UpdaterViewModelData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    val directDownloadList: List<DirectDownloadListItem> = listOf(),
    val onDismissRequested: () -> Unit = {},
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
