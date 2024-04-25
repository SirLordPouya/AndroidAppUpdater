package com.pouyaheydari.appupdater.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.directdownload.domain.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.main.pojo.DialogStates
import com.pouyaheydari.appupdater.main.utils.ErrorCallbackHolder
import com.pouyaheydari.appupdater.main.utils.TypefaceHolder
import com.pouyaheydari.appupdater.store.domain.ShowStoreModel
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AppUpdaterDialog]
 */
internal class AppUpdaterViewModel : ViewModel() {
    val screenState = MutableStateFlow<DialogStates>(DialogStates.HideUpdateInProgress)

    fun onStoreClicked(item: StoreListItem) {
        viewModelScope.launch {
            val storeModel = ShowStoreModel(item.store, ::onErrorWhileOpeningStore)
            screenState.value = DialogStates.OpenStore(storeModel)
            runWithDelay {
                screenState.value = DialogStates.Empty
            }
        }
    }

    fun onDirectDownloadLinkClicked(item: DirectDownloadListItem) {
        screenState.value = DialogStates.DownloadApk(item.url)
    }

    fun onDownloadStarted() {
        observeUpdateInProgressStatus()
    }

    private fun onErrorWhileOpeningStore(storeName: String) {
        viewModelScope.launch {
            screenState.value = DialogStates.ExecuteErrorCallback(storeName)
            runWithDelay {
                screenState.value = DialogStates.Empty
            }
        }
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

    private suspend fun runWithDelay(job: () -> Unit) {
        delay(100)
        job()
    }
}
