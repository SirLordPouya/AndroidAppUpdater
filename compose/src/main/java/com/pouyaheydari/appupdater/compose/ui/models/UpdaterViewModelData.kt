package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.data.model.StoreListItem
import com.pouyaheydari.appupdater.core.data.model.Theme

internal data class UpdaterViewModelData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    inline val onDismissRequested: () -> Unit = {},
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
