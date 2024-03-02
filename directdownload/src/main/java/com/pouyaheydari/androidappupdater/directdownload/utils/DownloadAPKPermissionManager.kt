package com.pouyaheydari.androidappupdater.directdownload.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.Locale

private const val PERMISSION_REQUEST_CODE = 2000

@SuppressLint("NewApi")
internal fun checkAndRequestRequiredPermissionsBasedOnOsVersion(activity: Activity, androidVersion: Int): Boolean = when {
    isInstallFromUnknownSourcePermissionRequired(androidVersion, activity) -> requestInstallFromUnknownSourcePermission(activity)
    haveAllPermissionsResolved(activity, androidVersion) -> true
    else -> getWriteToStoragePermission(activity)
}

@SuppressLint("NewApi")
private fun isInstallFromUnknownSourcePermissionRequired(androidVersion: Int, activity: Activity) =
    androidVersion >= Build.VERSION_CODES.P && !activity.packageManager.canRequestPackageInstalls()

// TODO: Add a dialog to explain to the user why are we getting this permission
@RequiresApi(Build.VERSION_CODES.O)
internal fun requestInstallFromUnknownSourcePermission(context: Context): Boolean {
    val uri = Uri.parse(String.format(Locale.ENGLISH, "package:%s", context.packageName))
    val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, uri).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(intent)
    return false
}

private fun haveAllPermissionsResolved(activity: Activity, androidVersion: Int) =
    hasWriteToStoragePermission(activity) || androidVersion > Build.VERSION_CODES.P

private fun hasWriteToStoragePermission(context: Context): Boolean =
    ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

// TODO: Use ActivityCompat.shouldShowRequestPermissionRationale to provide details on why the permission is needed
private fun getWriteToStoragePermission(activity: Activity): Boolean {
    ActivityCompat.requestPermissions(
        activity,
        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
        PERMISSION_REQUEST_CODE,
    )
    return false
}
