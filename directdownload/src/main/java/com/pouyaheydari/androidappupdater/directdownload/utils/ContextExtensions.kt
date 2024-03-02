package com.pouyaheydari.androidappupdater.directdownload.utils

import android.content.Context
import android.os.Environment
import com.pouyaheydari.appupdater.core.utils.APK_NAME
import java.io.File

/**
 * @return a File to the previously downloaded APK file if present.
 */
internal fun Context.getExistingApk() = File("${this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)}/$APK_NAME")
