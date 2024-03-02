package com.pouyaheydari.androidappupdater.directdownload.domain

import com.pouyaheydari.androidappupdater.directdownload.data.UpdateInProgressRepositoryImpl

internal class GetRequestIdInteractor(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(): Long = repository.getRequestId()
}
