package com.pouyaheydari.appupdater.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.core.interactors.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.DialogStates
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.utils.runWithDelay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AndroidAppUpdater]
 */
internal class AndroidAppUpdaterViewModel : ViewModel() {
    val screenState = MutableStateFlow<DialogStates>(DialogStates.HideUpdateInProgress)
    private val getIsUpdateInProgress by lazy { GetIsUpdateInProgress() }

    fun onListItemClicked(item: StoreListItem) {
        when (item.store) {
            Store.DIRECT_URL -> startDirectUrlApkDownload(item)
            else -> showAppInSelectedStore(item)
        }
    }

    private fun showAppInSelectedStore(item: StoreListItem) {
        viewModelScope.launch {
            val store = item.store.provider?.getDeclaredConstructor()?.newInstance()?.also { it.setStoreData(item) }
            screenState.value = DialogStates.OpenStore(store)
            runWithDelay {
                screenState.value = DialogStates.Empty
            }
        }
    }

    private fun startDirectUrlApkDownload(item: StoreListItem) {
        observeUpdateProgress()
        screenState.value = DialogStates.DownloadApk(item.url)
    }

    private fun observeUpdateProgress() {
        viewModelScope.launch {
            getIsUpdateInProgress().collectLatest {
                screenState.value = if (it) DialogStates.ShowUpdateInProgress else DialogStates.HideUpdateInProgress
            }
        }
    }
}
