package com.pouyaheydari.appupdater.core.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.widget.Toast
import com.pouyaheydari.appupdater.core.R
import com.pouyaheydari.appupdater.core.data.model.ShowStoreModel
import java.util.Locale

fun showAppInSelectedStore(context: Context?, storeModel: ShowStoreModel) {
    try {
        val intent = storeModel.store.provider?.getDeclaredConstructor()?.newInstance()?.getIntent(storeModel.packageName)
        intent?.addFlags(FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        openWebViewToShowFallbackUrl(context, storeModel.fallbackUrl, storeModel.store.name)
    }
}

private fun openWebViewToShowFallbackUrl(context: Context?, fallbackUrl: String, storeName: String) {
    if (fallbackUrl.isNotEmpty()) {
        try {
            val webViewIntent = Intent(Intent.ACTION_VIEW, Uri.parse(fallbackUrl)).run {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }
            context?.startActivity(webViewIntent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            showErrorToast(context, storeName)
        }
    } else {
        showErrorToast(context, storeName)
    }
}

private fun showErrorToast(context: Context?, storeName: String) {
    val lowerCaseStoreName = storeName.lowercase(Locale.ROOT).replace("_", " ")
    Toast.makeText(
        context,
        context?.getString(R.string.appupdater_please_install, lowerCaseStoreName),
        Toast.LENGTH_LONG,
    ).show()
}
