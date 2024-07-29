package com.pouyaheydari.appupdater.compose.ui.models

import androidx.annotation.DrawableRes
import com.pouyaheydari.appupdater.store.R as storeR

internal data class DialogHeaderModel(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    @DrawableRes val dialogIcon: Int = storeR.drawable.appupdater_ic_cloud,
)
