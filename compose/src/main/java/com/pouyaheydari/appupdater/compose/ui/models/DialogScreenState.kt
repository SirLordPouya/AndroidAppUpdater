package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.stores.AppStore
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType

internal data class DialogScreenState(
    val shouldShowDialog: Boolean = true,
    val shouldShowUpdateInProgress: Boolean = false,
    val errorWhileOpeningStore: ErrorWhileOpeningStore = ErrorWhileOpeningStore(),
    val selectedStore: AppStore = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, ""),
    val shouldOpenStore: Boolean = false,
    val downloadUrl: String = "",
    val shouldStartAPKDownload: Boolean = false,
    val dialogContent: UpdaterDialogUIData = UpdaterDialogUIData(),
)

internal data class ErrorWhileOpeningStore(
    val shouldNotifyCaller: Boolean = false,
    val storeName: String = "",
)
