package com.pouyaheydari.appupdater.compose.pojo

import android.graphics.Typeface
import com.pouyaheydari.appupdater.core.pojo.StoreListItem

/**
 * This model is used to pass dialog content to [com.pouyaheydari.appupdater.compose.DialogContent]
 */
internal data class UpdaterDialogUIData(
    val dialogTitle: String,
    val dialogDescription: String,
    val directDownloadList: List<StoreListItem>,
    val storeList: List<StoreListItem>,
    val typeface: Typeface?,
    val onClickListener: (StoreListItem) -> Unit,
    val shouldShowDividers: Boolean,
)
