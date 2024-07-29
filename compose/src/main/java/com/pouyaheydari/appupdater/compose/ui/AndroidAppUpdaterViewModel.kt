package com.pouyaheydari.appupdater.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.appupdater.compose.data.mapper.UpdaterDialogUIMapper
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenIntents
import com.pouyaheydari.appupdater.compose.ui.models.DialogScreenState
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.directdownload.domain.GetIsUpdateInProgress
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.stores.AppStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * View Model of [AndroidAppUpdater]
 */
internal class AndroidAppUpdaterViewModel(
    viewModelData: UpdaterViewModelData,
    private val isUpdateInProgress: GetIsUpdateInProgress,
) : ViewModel() {
    private val _uiState = MutableStateFlow(DialogScreenState())
    val uiState: StateFlow<DialogScreenState> = _uiState.asStateFlow()

    init {
        showUpdaterDialog(viewModelData)
    }

    private fun showUpdaterDialog(viewModelData: UpdaterViewModelData) {
        val dialogContent = UpdaterDialogUIMapper.map(
            viewModelData,
            { handleIntent(DialogScreenIntents.OnStoreClicked(it)) },
            { handleIntent(DialogScreenIntents.OnDirectLinkClicked(it)) },
        )
        _uiState.update { it.copy(shouldShowDialog = true, dialogContent = dialogContent) }
    }

    fun handleIntent(intent: DialogScreenIntents) {
        when (intent) {
            is DialogScreenIntents.OnDirectLinkClicked -> startDirectUrlApkDownload(intent.item)
            is DialogScreenIntents.OnStoreClicked -> showAppInSelectedStore(intent.item)
            DialogScreenIntents.OnStoreOpened -> _uiState.update { it.copy(shouldOpenStore = false) }
            DialogScreenIntents.OnErrorCallbackExecuted -> _uiState.update { it.copy(errorWhileOpeningStore = it.errorWhileOpeningStore.copy(shouldNotifyCaller = false)) }
            DialogScreenIntents.OnApkDownloadRequested -> _uiState.update { it.copy(shouldStartAPKDownload = false) }
            DialogScreenIntents.OnApkDownloadStarted -> observeUpdateProgress()
            is DialogScreenIntents.OnOpeningStoreFailed -> observeErrorWhileShowingStore(intent.store)
        }
    }

    private fun showAppInSelectedStore(item: StoreListItem) {
        _uiState.update { it.copy(selectedStore = item.store, shouldOpenStore = true) }
    }

    private fun observeErrorWhileShowingStore(store: AppStore) {
        _uiState.update {
            it.copy(errorWhileOpeningStore = it.errorWhileOpeningStore.copy(shouldNotifyCaller = true, storeName = store.getUserReadableName()))
        }
    }

    private fun startDirectUrlApkDownload(item: DirectDownloadListItem) {
        _uiState.update { it.copy(shouldStartAPKDownload = true, downloadUrl = item.url) }
    }

    private fun observeUpdateProgress() {
        viewModelScope.launch {
            isUpdateInProgress().collectLatest { updateInProgress ->
                _uiState.update { it.copy(shouldShowUpdateInProgress = updateInProgress, shouldStartAPKDownload = false, shouldOpenStore = false) }
            }
        }
    }
}
