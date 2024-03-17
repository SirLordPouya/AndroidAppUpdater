package com.pouyaheydari.androidappupdater.store.domain

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.util.Log
import com.pouyaheydari.androidappupdater.store.ShowStoreModel
import com.pouyaheydari.appupdater.core.utils.ANDROID_APP_UPDATER_DEBUG_TAG
import java.util.Locale

fun showAppInSelectedStore(context: Context?, storeModel: ShowStoreModel) {
    try {
        val intent = storeModel.store.getIntent()
        context?.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        showFallbackUrlOrCallErrorFallback(storeModel, context)
    }
}

private fun showFallbackUrlOrCallErrorFallback(storeModel: ShowStoreModel, context: Context?) {
    if (storeModel.fallbackUrl.isNotEmpty()) {
        showFallbackUrlInDefaultBrowser(context, storeModel)
    } else {
        handleError(storeModel.store.javaClass.name, storeModel.errorCallBack)
    }
}

private fun showFallbackUrlInDefaultBrowser(context: Context?, storeModel: ShowStoreModel) {
    try {
        val webViewIntent = Intent(Intent.ACTION_VIEW, Uri.parse(storeModel.fallbackUrl)).run {
            addFlags(FLAG_ACTIVITY_NEW_TASK)
        }
        context?.startActivity(webViewIntent)
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        handleError(storeModel.store.javaClass.name, storeModel.errorCallBack)
    }
}

private fun handleError(storeName: String, errorCallBack: () -> Unit) {
    val lowerCaseStoreName = storeName.lowercase(Locale.ROOT).replace("_", " ")
    Log.e(ANDROID_APP_UPDATER_DEBUG_TAG, "$lowerCaseStoreName is not installed")
    errorCallBack()
}
