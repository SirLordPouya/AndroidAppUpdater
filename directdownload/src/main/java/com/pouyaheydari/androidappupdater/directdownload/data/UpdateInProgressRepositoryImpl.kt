package com.pouyaheydari.androidappupdater.directdownload.data

import com.pouyaheydari.androidappupdater.directdownload.domain.UpdateInProgressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onStart
import java.util.concurrent.atomic.AtomicLong

private const val NO_REQUEST_ID = -10L

internal object UpdateInProgressRepositoryImpl : UpdateInProgressRepository {
    private var requestId: AtomicLong = AtomicLong(NO_REQUEST_ID)
    private val shouldShowUpdateInProgressDialog = MutableSharedFlow<Boolean>(replay = 1)

    override fun getRequestId(): Long = requestId.get()

    override fun setRequestId(id: Long) {
        requestId.set(id)
    }

    override fun getUpdateInProgressFlow(): Flow<Boolean> = shouldShowUpdateInProgressDialog.asSharedFlow().onStart {
        emit(true)
    }

    override suspend fun updateApkDownloadProgress(isInProgress: Boolean) {
        shouldShowUpdateInProgressDialog.emit(isInProgress)
    }
}
