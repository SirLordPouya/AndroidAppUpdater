package com.pouyaheydari.appupdater.pojo

import com.pouyaheydari.appupdater.core.data.model.ShowStoreModel

/**
 * Represents UI states of the update dialog
 */
sealed interface DialogStates {
    data object Empty : DialogStates
    data object ShowUpdateInProgress : DialogStates
    data object HideUpdateInProgress : DialogStates
    data class OpenStore(val store: ShowStoreModel) : DialogStates
    data class DownloadApk(val apkUrl: String) : DialogStates
}
