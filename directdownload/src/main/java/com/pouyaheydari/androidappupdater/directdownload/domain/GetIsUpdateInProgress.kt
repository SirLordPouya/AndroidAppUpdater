package com.pouyaheydari.androidappupdater.directdownload.domain

import com.pouyaheydari.androidappupdater.directdownload.data.UpdateInProgressRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetIsUpdateInProgress(private val repository: UpdateInProgressRepository = UpdateInProgressRepositoryImpl) {
    operator fun invoke(): Flow<Boolean> = repository.getUpdateInProgressFlow()
}
