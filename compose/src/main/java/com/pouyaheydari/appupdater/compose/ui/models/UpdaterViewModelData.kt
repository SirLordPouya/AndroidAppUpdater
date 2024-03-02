package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.androidappupdater.store.model.StoreListItem
import com.pouyaheydari.androidappupdater.store.model.Theme

internal data class UpdaterViewModelData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    inline val onDismissRequested: () -> Unit = {},
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
