package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.pojo.StoreListItem

internal sealed interface DialogState {
    data class ShowDialog(
        val dialogContent: UpdaterDialogUIData,
        inline val onItemClickListener: (StoreListItem) -> Unit,
    ) : DialogState

    data object HideDialog : DialogState
}
