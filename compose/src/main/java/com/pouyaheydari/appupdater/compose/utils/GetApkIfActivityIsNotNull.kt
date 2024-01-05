package com.pouyaheydari.appupdater.compose.utils

import android.app.Activity
import android.util.Log
import com.pouyaheydari.appupdater.core.utils.TAG
import com.pouyaheydari.appupdater.core.utils.getApk

fun getApkIfActivityIsNotNull(
    activity: Activity?,
    url: String,
) {
    if (activity == null) {
        Log.e(TAG, "Provided activity is null. Skipping downloading the apk")
    } else {
        getApk(url, activity)
    }
}
