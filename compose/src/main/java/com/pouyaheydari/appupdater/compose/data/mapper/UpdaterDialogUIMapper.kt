package com.pouyaheydari.appupdater.compose.data.mapper

import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData

internal object UpdaterDialogUIMapper {
    fun map(viewModelData: UpdaterViewModelData): UpdaterDialogUIData = with(viewModelData) {
        UpdaterDialogUIData(
            dialogHeader = DialogHeaderModel(dialogTitle, dialogDescription),
            directDownloadList = viewModelData.directDownloadList,
            storeList = viewModelData.storeList,
            shouldShowDividers = shouldShowStoresDivider(viewModelData.directDownloadList, viewModelData.storeList),
            onDismissRequested = onDismissRequested,
        )
    }

    private fun shouldShowStoresDivider(directDownloadList: List<DirectDownloadListItem>, storeList: List<StoreListItem>) =
        directDownloadList.isNotEmpty() && storeList.isNotEmpty()
}
