package com.pouyaheydari.appupdater.compose.ui.models

import androidx.annotation.DrawableRes
import com.pouyaheydari.appupdater.core.R

internal data class DialogHeaderModel(
    val dialogTitle: String = "",
    val dialogDescription: String = "",
    @DrawableRes val dialogIcon: Int = R.drawable.appupdater_ic_cloud,
)
