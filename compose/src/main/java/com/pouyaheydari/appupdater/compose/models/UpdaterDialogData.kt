package com.pouyaheydari.appupdater.compose.models

import android.graphics.Typeface
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme

/**
 * This model is used to pass data to config the [com.pouyaheydari.appupdater.compose.AndroidAppUpdater]
 */
data class UpdaterDialogData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    val onDismissRequested: () -> Unit = {},
    val typeface: Typeface? = null,
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
