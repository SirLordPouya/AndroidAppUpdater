package com.pouyaheydari.appupdater.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.compose.domain.mapper.UpdaterDialogUIMapper
import com.pouyaheydari.appupdater.compose.ui.models.DialogState
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData
import com.pouyaheydari.appupdater.core.interactors.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.DialogStates
import com.pouyaheydari.appupdater.core.pojo.DialogStates.DownloadApk
import com.pouyaheydari.appupdater.core.pojo.DialogStates.Empty
import com.pouyaheydari.appupdater.core.pojo.DialogStates.HideUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.DialogStates.OpenStore
import com.pouyaheydari.appupdater.core.pojo.DialogStates.ShowUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.utils.runWithDelay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AndroidAppUpdater]
 */
internal class AndroidAppUpdaterViewModel(
    viewModelData: UpdaterViewModelData,
    private val isUpdateInProgress: GetIsUpdateInProgress,
) : ViewModel() {
    val dialogState = MutableStateFlow<DialogState>(DialogState.HideDialog)
    val screenState = MutableStateFlow<DialogStates>(Empty)

    init {
        showUpdaterDialog(viewModelData)
    }

    private fun showUpdaterDialog(viewModelData: UpdaterViewModelData) {
        val dialogContent = UpdaterDialogUIMapper.map(viewModelData)
        dialogState.value = DialogState.ShowDialog(dialogContent, ::onListItemClicked)
    }

    private fun onListItemClicked(item: StoreListItem) {
        when (item.store) {
            Store.DIRECT_URL -> startDirectUrlApkDownload(item)
            else -> showAppInSelectedStore(item)
        }
    }

    private fun showAppInSelectedStore(item: StoreListItem) {
        viewModelScope.launch {
            val store = item.store.provider?.getDeclaredConstructor()?.newInstance()?.also { it.setStoreData(item) }
            screenState.value = OpenStore(store)
            runWithDelay {
                screenState.value = Empty
            }
        }
    }

    private fun startDirectUrlApkDownload(item: StoreListItem) {
        observeUpdateProgress()
        screenState.value = DownloadApk(item.url)
    }

    private fun observeUpdateProgress() {
        viewModelScope.launch {
            isUpdateInProgress().collectLatest {
                screenState.value = if (it) ShowUpdateInProgress else HideUpdateInProgress
            }
        }
    }
}
