package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.stores.AppStore

internal sealed interface DialogScreenIntents {
    data class OnStoreClicked(val item: StoreListItem) : DialogScreenIntents
    data class OnDirectLinkClicked(val item: DirectDownloadListItem) : DialogScreenIntents
    data object OnStoreOpened : DialogScreenIntents
    data class OnOpeningStoreFailed(val store: AppStore) : DialogScreenIntents
    data object OnErrorCallbackExecuted : DialogScreenIntents
    data object OnApkDownloadStarted : DialogScreenIntents
    data object OnApkDownloadRequested : DialogScreenIntents
}
