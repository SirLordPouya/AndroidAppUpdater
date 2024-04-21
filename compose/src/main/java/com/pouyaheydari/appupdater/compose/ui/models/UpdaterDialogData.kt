package com.pouyaheydari.appupdater.compose.ui.models

import android.graphics.Typeface
import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.core.model.Theme

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
