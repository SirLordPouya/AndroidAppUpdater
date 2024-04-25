package com.pouyaheydari.appupdater.directdownload.domain

import com.pouyaheydari.appupdater.directdownload.data.UpdateInProgressRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetIsUpdateInProgress(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(): Flow<Boolean> = repository.getUpdateInProgressFlow()
}
