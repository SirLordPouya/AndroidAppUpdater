package com.pouyaheydari.androidappupdater.directdownload.domain

import com.pouyaheydari.androidappupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class SetRequestIdInteractor(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(requestId: Long) {
        repository.setRequestId(requestId)
    }
}
