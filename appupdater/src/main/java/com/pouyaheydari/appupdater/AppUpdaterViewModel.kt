package com.pouyaheydari.appupdater

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.core.interactors.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.utils.runWithDelay
import com.pouyaheydari.appupdater.pojo.DialogStates
import com.pouyaheydari.appupdater.utils.TypefaceHolder
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
                val store = item.store.provider?.newInstance()?.also { it.setStoreData(item) }
                screenState.value = DialogStates.OpenStore(store)
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
}
