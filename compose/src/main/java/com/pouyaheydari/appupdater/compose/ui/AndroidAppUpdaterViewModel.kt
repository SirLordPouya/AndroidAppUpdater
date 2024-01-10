package com.pouyaheydari.appupdater.compose.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.compose.data.mapper.UpdaterDialogUIMapper
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenIntents
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenState
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData
import com.pouyaheydari.appupdater.core.interactors.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * View Model of [AndroidAppUpdater]
 */
internal class AndroidAppUpdaterViewModel(
    viewModelData: UpdaterViewModelData,
    private val isUpdateInProgress: GetIsUpdateInProgress,
) : ViewModel() {
    private val _uiState = mutableStateOf(DialogScreenState())
    val uiState: State<DialogScreenState>
        get() = _uiState

    init {
        showUpdaterDialog(viewModelData)
    }

    private fun showUpdaterDialog(viewModelData: UpdaterViewModelData) {
        val dialogContent = UpdaterDialogUIMapper.map(viewModelData)
        updateState { copy(shouldShowDialog = true, dialogContent = dialogContent) }
    }

    fun handleIntent(intent: DialogScreenIntents) {
        when (intent) {
            is DialogScreenIntents.OnDirectLinkClicked -> startDirectUrlApkDownload(intent.item)
            is DialogScreenIntents.OnStoreClicked -> showAppInSelectedStore(intent.item)
            DialogScreenIntents.OnStoreOpened -> updateState { copy(shouldOpenStore = false) }
        }
    }

    private fun showAppInSelectedStore(item: StoreListItem) {
        viewModelScope.launch {
            val store = item.store.provider?.getDeclaredConstructor()?.newInstance()?.also { it.setStoreData(item) }
            updateState { copy(selectedStore = store, shouldOpenStore = true) }
        }
    }

    private fun startDirectUrlApkDownload(item: StoreListItem) {
        observeUpdateProgress()
        updateState { copy(shouldShowUpdateInProgress = true, shouldStartAPKDownload = true, downloadUrl = item.url) }
    }

    private fun observeUpdateProgress() {
        viewModelScope.launch {
            isUpdateInProgress().collectLatest { updateInProgress ->
                updateState { copy(shouldShowUpdateInProgress = updateInProgress, shouldStartAPKDownload = false, shouldOpenStore = false) }
            }
        }
    }

    private fun updateState(reduce: DialogScreenState.() -> DialogScreenState) {
        _uiState.value = _uiState.value.reduce()
    }
}
