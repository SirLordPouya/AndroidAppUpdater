package com.pouyaheydari.appupdater.core.interactors

import com.pouyaheydari.appupdater.core.data.Repository
import kotlinx.coroutines.flow.Flow

class GetIsUpdateInProgress {
    operator fun invoke(): Flow<Boolean> = Repository.shouldShowUpdateInProgressDialog
}
