package com.pouyaheydari.appupdater.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pouyaheydari.appupdater.compose.data.mapper.UpdaterViewModelDataMapper
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.directdownload.domain.GetIsUpdateInProgress

internal class AndroidAppUpdaterViewModelFactory(
    private val dialogData: UpdaterDialogData,
    private val getIsUpdateInProgress: GetIsUpdateInProgress = GetIsUpdateInProgress(),
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelData = UpdaterViewModelDataMapper.map(dialogData)
        return AndroidAppUpdaterViewModel(viewModelData, getIsUpdateInProgress) as T
    }
}