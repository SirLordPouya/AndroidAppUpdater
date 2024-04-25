package com.pouyaheydari.appupdater.store.domain

import android.content.ActivityNotFoundException
import android.content.Context
import android.util.Log
import com.pouyaheydari.appupdater.core.utils.ANDROID_APP_UPDATER_DEBUG_TAG
import java.util.Locale

fun showAppInSelectedStore(context: Context?, storeModel: ShowStoreModel) {
    try {
        val intent = storeModel.store.getIntent()
        context?.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        handleError(storeModel.store.javaClass.name, storeModel.errorCallBack)
    }
}

private fun handleError(storeName: String, errorCallBack: (String) -> Unit) {
    val lowerCaseStoreName = storeName.lowercase(Locale.ROOT).replace("_", " ")
    Log.e(ANDROID_APP_UPDATER_DEBUG_TAG, "$lowerCaseStoreName is not installed")
    errorCallBack(storeName)
}
