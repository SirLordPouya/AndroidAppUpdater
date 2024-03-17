package com.pouyaheydari.androidappupdater.directdownload.domain

import kotlinx.coroutines.flow.Flow

interface UpdateInProgressRepository {
    fun getRequestId(): Long
    fun setRequestId(id: Long)
    fun getUpdateInProgressFlow(): Flow<Boolean>
    suspend fun updateApkDownloadProgress(isInProgress: Boolean)
}
