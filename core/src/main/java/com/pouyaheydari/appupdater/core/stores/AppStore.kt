package com.pouyaheydari.appupdater.core.stores

import android.content.Intent

interface AppStore {
    fun getIntent(packageName: String): Intent
}
