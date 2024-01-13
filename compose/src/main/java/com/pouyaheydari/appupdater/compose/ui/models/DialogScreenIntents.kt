package com.pouyaheydari.appupdater.compose.ui.models

import com.pouyaheydari.appupdater.core.data.model.StoreListItem

internal sealed interface DialogScreenIntents {
    data class OnStoreClicked(val item: StoreListItem) : DialogScreenIntents
    data class OnDirectLinkClicked(val item: StoreListItem) : DialogScreenIntents
    data object OnStoreOpened : DialogScreenIntents
}
