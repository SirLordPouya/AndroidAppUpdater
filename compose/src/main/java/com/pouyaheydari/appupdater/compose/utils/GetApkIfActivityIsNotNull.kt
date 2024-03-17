package com.pouyaheydari.appupdater.compose.utils

import android.app.Activity
import android.util.Log
import com.pouyaheydari.androidappupdater.directdownload.utils.getApk
import com.pouyaheydari.appupdater.core.utils.ANDROID_APP_UPDATER_DEBUG_TAG

suspend fun getApkIfActivityIsNotNull(activity: Activity?, url: String) {
    if (activity == null) {
        Log.e(ANDROID_APP_UPDATER_DEBUG_TAG, "Provided activity is null. Skipping downloading the apk")
    } else {
        getApk(url, activity)
    }
}
