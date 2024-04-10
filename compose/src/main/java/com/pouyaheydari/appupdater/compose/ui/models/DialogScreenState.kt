package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.androidappupdater.store.ShowStoreModel

internal data class DialogScreenState(
    val shouldShowDialog: Boolean = true,
    val shouldShowUpdateInProgress: Boolean = false,
    val errorWhileOpeningStore: ErrorWhileOpeningStore = ErrorWhileOpeningStore(),
    val selectedStore: ShowStoreModel = ShowStoreModel(),
    val shouldOpenStore: Boolean = false,
    val downloadUrl: String = "",
    val shouldStartAPKDownload: Boolean = false,
    val dialogContent: UpdaterDialogUIData = UpdaterDialogUIData(),
)

internal data class ErrorWhileOpeningStore(
    val shouldNotifyCaller: Boolean = false,
    val storeName: String = "",
)
