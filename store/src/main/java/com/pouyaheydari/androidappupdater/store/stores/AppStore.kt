package com.pouyaheydari.androidappupdater.store.stores

import android.content.Intent

interface AppStore {
    fun getIntent(packageName: String): Intent
}
