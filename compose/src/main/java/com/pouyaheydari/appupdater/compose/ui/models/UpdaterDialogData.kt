package com.pouyaheydari.appupdater.compose.ui.models

import android.graphics.Typeface
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme

/**
 * This model is used to pass data to config the [com.pouyaheydari.appupdater.compose.ui.AndroidAppUpdater]
 */
data class UpdaterDialogData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val storeList: List<StoreListItem> = listOf(),
    inline val onDismissRequested: () -> Unit = {},
    val typeface: Typeface? = null,
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)
