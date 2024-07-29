package com.pouyaheydari.appupdater.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.directdownload.domain.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.main.pojo.DialogStates
import com.pouyaheydari.appupdater.main.utils.ErrorCallbackHolder
import com.pouyaheydari.appupdater.main.utils.TypefaceHolder
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.stores.AppStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AppUpdaterDialog]
 */
internal class AppUpdaterViewModel : ViewModel() {
    val screenState = MutableStateFlow<DialogStates>(DialogStates.HideUpdateInProgress)

    fun onStoreClicked(item: StoreListItem) {
        screenState.value = DialogStates.OpenStore(item.store)
    }

    fun onStoreOpened() {
        screenState.value = DialogStates.Empty
    }

    fun onDirectDownloadLinkClicked(item: DirectDownloadListItem) {
        screenState.value = DialogStates.DownloadApk(item.url)
    }

    fun onErrorCallbackCalled() {
        screenState.value = DialogStates.Empty
    }

    fun onDownloadStarted() {
        observeUpdateInProgressStatus()
    }

    fun onErrorWhileOpeningStore(store: AppStore) {
        screenState.value = DialogStates.ExecuteErrorCallback(store.getUserReadableName())
    }

    private fun observeUpdateInProgressStatus() {
        viewModelScope.launch {
            GetIsUpdateInProgress().invoke().collectLatest {
                screenState.value = if (it) DialogStates.ShowUpdateInProgress else DialogStates.HideUpdateInProgress
            }
        }
    }

    override fun onCleared() {
        TypefaceHolder.clear()
        ErrorCallbackHolder.clear()
        super.onCleared()
    }
}
