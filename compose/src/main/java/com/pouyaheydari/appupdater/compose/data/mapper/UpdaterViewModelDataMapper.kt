package com.pouyaheydari.appupdater.compose.data.mapper

import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData

internal object UpdaterViewModelDataMapper {
    fun map(dialogData: UpdaterDialogData): UpdaterViewModelData = with(dialogData) {
        UpdaterViewModelData(
            dialogTitle = dialogTitle,
            dialogDescription = dialogDescription,
            storeList = storeList,
            directDownloadList = directDownloadList,
            onDismissRequested = onDismissRequested,
            theme = theme,
        )
    }
}
