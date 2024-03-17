package com.pouyaheydari.appupdater.pojo

import android.graphics.Typeface
import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.core.model.Theme

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
    var theme: Theme = Theme.SYSTEM_DEFAULT,
)
