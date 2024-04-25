package com.pouyaheydari.appupdater.main.pojo

import android.graphics.Typeface
import com.pouyaheydari.appupdater.core.model.Theme
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem

/**
 * This model is used to pass the data to dialog fragment via bundles
 */
data class UpdaterDialogData(
    var title: String = "",
    var description: String = "",
    var storeList: List<StoreListItem> = listOf(),
    var directDownloadList: List<DirectDownloadListItem> = listOf(),
    var isForceUpdate: Boolean = false,
    var typeface: Typeface? = null,
    var errorWhileOpeningStoreCallback: ((String) -> Unit)? = null,
    var theme: Theme = Theme.SYSTEM_DEFAULT,
)
