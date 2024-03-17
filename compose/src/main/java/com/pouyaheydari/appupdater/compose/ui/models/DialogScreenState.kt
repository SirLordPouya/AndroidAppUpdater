package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.androidappupdater.store.ShowStoreModel

internal data class DialogScreenState(
    val shouldShowDialog: Boolean = true,
    val shouldShowUpdateInProgress: Boolean = false,
    val selectedStore: ShowStoreModel = ShowStoreModel(),
    val shouldOpenStore: Boolean = false,
    val downloadUrl: String = "",
    val shouldStartAPKDownload: Boolean = false,
    val dialogContent: UpdaterDialogUIData = UpdaterDialogUIData(),
)
