package com.pouyaheydari.androidappupdater.directdownload.domain

import com.pouyaheydari.androidappupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class SetIsUpdateInProgress(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    suspend operator fun invoke(isUpdateInProgress: Boolean) {
        repository.updateApkDownloadProgress(isUpdateInProgress)
    }
}
