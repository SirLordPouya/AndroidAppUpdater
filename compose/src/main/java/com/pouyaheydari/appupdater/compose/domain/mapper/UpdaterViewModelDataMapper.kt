package com.pouyaheydari.appupdater.compose.domain.mapper

import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterViewModelData

internal object UpdaterViewModelDataMapper {
    fun map(dialogData: UpdaterDialogData): UpdaterViewModelData = with(dialogData) {
        UpdaterViewModelData(
            dialogTitle = dialogTitle,
            dialogDescription = dialogDescription,
            storeList = storeList,
            onDismissRequested = onDismissRequested,
            theme = theme,
        )
    }
}
