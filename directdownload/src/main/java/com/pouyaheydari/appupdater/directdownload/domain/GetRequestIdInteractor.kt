package com.pouyaheydari.appupdater.directdownload.domain

import com.pouyaheydari.appupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class GetRequestIdInteractor(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(): Long = repository.getRequestId()
}
