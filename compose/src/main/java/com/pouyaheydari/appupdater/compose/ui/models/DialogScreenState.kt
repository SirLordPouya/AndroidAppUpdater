package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.stores.Stores

internal data class DialogScreenState(
    val shouldShowDialog: Boolean = true,
    val shouldShowUpdateInProgress: Boolean = false,
    val selectedStore: Stores? = null,
    val shouldOpenStore: Boolean = false,
    val downloadUrl: String = "",
    val shouldStartAPKDownload: Boolean = false,
    val dialogContent: UpdaterDialogUIData = UpdaterDialogUIData(),
)
