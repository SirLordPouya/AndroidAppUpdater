package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme

internal data class UpdaterViewModelData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    inline val onDismissRequested: () -> Unit = {},
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
