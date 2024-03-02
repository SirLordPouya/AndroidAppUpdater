package com.pouyaheydari.appupdater.compose.data.mapper

import com.pouyaheydari.androidappupdater.store.model.Store
import com.pouyaheydari.androidappupdater.store.shouldShowStoresDivider
import com.pouyaheydari.appupdater.compose.ui.models.DialogHeaderModel
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogUIData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData

internal object UpdaterDialogUIMapper {
    fun map(viewModelData: UpdaterViewModelData): UpdaterDialogUIData = with(viewModelData) {
        val (directDownloadItems, storeItems) = storeList.partition { it.store == Store.DIRECT_URL }
        UpdaterDialogUIData(
            dialogHeader = DialogHeaderModel(dialogTitle, dialogDescription),
            directDownloadList = directDownloadItems,
            storeList = storeItems,
            shouldShowDividers = shouldShowStoresDivider(directDownloadItems, storeItems),
            onDismissRequested = onDismissRequested,
        )
    }
}
