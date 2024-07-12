package com.pouyaheydari.appupdater.compose.ui.models

import android.graphics.Typeface
import com.pouyaheydari.appupdater.core.model.Theme
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem

/**
 * This model is used to pass data to config the [com.pouyaheydari.appupdater.compose.ui.AndroidAppUpdater]
 */
data class UpdaterDialogData(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    val dividerText: String = "",
    val storeList: List<StoreListItem> = listOf(),
    val directDownloadList: List<DirectDownloadListItem> = listOf(),
    val onDismissRequested: () -> Unit = {},
    val errorWhileOpeningStoreCallback: (String) -> Unit = {},
    val typeface: Typeface? = null,
    val theme: Theme = Theme.SYSTEM_DEFAULT,
)