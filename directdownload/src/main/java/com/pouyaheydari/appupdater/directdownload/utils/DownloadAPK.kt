package com.pouyaheydari.appupdater.directdownload.utils

import android.app.Activity
import android.app.DownloadManager
import android.app.DownloadManager.Request.NETWORK_MOBILE
import android.app.DownloadManager.Request.NETWORK_WIFI
import android.app.DownloadManager.Request.VISIBILITY_VISIBLE
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import com.pouyaheydari.appupdater.core.utils.APK_NAME
import com.pouyaheydari.appupdater.directdownload.R

/**
 * Checks for needed permissions and tries to download the apk
 */
fun getApk(url: String, activity: Activity, onDownloadingApkStarted: () -> Unit) {
    if (checkAndRequestRequiredPermissionsBasedOnOsVersion(activity, Build.VERSION.SDK_INT)) {
        prepareToDownloadApk(url, activity)
        onDownloadingApkStarted()
    }
}

private fun prepareToDownloadApk(url: String, context: Context) {
    // Delete APK if user downloaded the apk before
    deleteExistingApkIfAvailable(context)

    startDownloadManagerToDownloadNewApk(url, context)
}

private fun deleteExistingApkIfAvailable(context: Context) {
    val file = context.getExistingApk()
    if (file.exists()) {
        file.delete()
    }
}

private fun startDownloadManagerToDownloadNewApk(url: String, context: Context) {
    val downloadManager = DownloadManager.Request(Uri.parse(url)).run {
        // setting title and description to be shown on download notification
        setTitle(context.getString(R.string.appupdater_download_notification_title))
        setDescription(context.getString(R.string.appupdater_download_notification_desc))
        setNotificationVisibility(VISIBILITY_VISIBLE)
        setAllowedNetworkTypes(NETWORK_WIFI or NETWORK_MOBILE)
        // setting the destination of the downloaded file
        setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, APK_NAME)
    }

    // enqueue the file to start download
    val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    com.pouyaheydari.appupdater.directdownload.domain.SetRequestIdInteractor().invoke(manager.enqueue(downloadManager))
}
