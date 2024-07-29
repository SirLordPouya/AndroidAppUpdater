package com.pouyaheydari.appupdater.directdownload.domain

import com.pouyaheydari.appupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class SetRequestIdInteractor(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(requestId: Long) {
        repository.setRequestId(requestId)
    }
}
