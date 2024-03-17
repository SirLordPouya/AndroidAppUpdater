package com.pouyaheydari.androidappupdater.directdownload.utils

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.content.FileProvider
import com.pouyaheydari.appupdater.core.utils.ANDROID_APP_UPDATER_DEBUG_TAG
import java.io.File

/**
 * Uses different methods to install the apk depending the user's Android version
 */
internal fun installAPK(context: Context, apk: File, androidVersion: Int) {
    when {
        androidVersion in 0..Build.VERSION_CODES.M -> installAPKForMAndBellow(context, apk)
        androidVersion in Build.VERSION_CODES.N..Build.VERSION_CODES.O -> installAPKForNtoO(context, apk)
        androidVersion >= Build.VERSION_CODES.P -> installAPKForPAndAbove(context, apk)
    }
}

@SuppressLint("NewApi")
private fun installAPKForPAndAbove(context: Context, apk: File) {
    if (context.packageManager.canRequestPackageInstalls()) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, getFileUri(context, apk)).run {
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e(ANDROID_APP_UPDATER_DEBUG_TAG, e.message.orEmpty())
        }
    } else {
        requestInstallFromUnknownSourcePermission(context)
    }
}

@Suppress("DEPRECATION")
private fun installAPKForNtoO(context: Context, apk: File) {
    val install = Intent(Intent.ACTION_INSTALL_PACKAGE, getFileUri(context, apk)).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(install)
}

private fun getFileUri(context: Context, apk: File): Uri = FileProvider.getUriForFile(
    context,
    "${context.packageName}.fileProvider.GenericFileProvider",
    apk,
)

private fun installAPKForMAndBellow(context: Context, apk: File) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.fromFile(apk)).apply {
        type = "application/vnd.android.package-archive"
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(intent)
}
