package com.pouyaheydari.appupdater.directdownload.domain

import com.pouyaheydari.appupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class SetIsUpdateInProgress(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    suspend operator fun invoke(isUpdateInProgress: Boolean) {
        repository.updateApkDownloadProgress(isUpdateInProgress)
    }
}
