package com.pouyaheydari.appupdater

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.androidappupdater.directdownload.domain.GetIsUpdateInProgress
import com.pouyaheydari.androidappupdater.store.model.ShowStoreModel
import com.pouyaheydari.androidappupdater.store.model.Store
import com.pouyaheydari.androidappupdater.store.model.StoreListItem
import com.pouyaheydari.appupdater.pojo.DialogStates
import com.pouyaheydari.appupdater.utils.TypefaceHolder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AppUpdaterDialog]
 */
internal class AppUpdaterViewModel : ViewModel() {
    val screenState = MutableStateFlow<DialogStates>(DialogStates.HideUpdateInProgress)

    fun onListListener(item: StoreListItem) {
        when (item.store) {
            Store.DIRECT_URL -> {
                observeUpdateInProgressStatus()
                screenState.value = DialogStates.DownloadApk(item.url)
            }

            else -> viewModelScope.launch {
                val storeModel = ShowStoreModel(item.packageName, item.store, item.url)
                screenState.value = DialogStates.OpenStore(storeModel)
                runWithDelay {
                    screenState.value = DialogStates.HideUpdateInProgress
                }
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
        super.onCleared()
    }

    private suspend fun runWithDelay(job: () -> Unit) {
        delay(100)
        job()
    }
}
