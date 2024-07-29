package com.pouyaheydari.appupdater.main.utils

import android.os.Build
import android.os.Bundle
import android.os.Parcelable

/**
 * This extension function helps with using parcelables,
 * as [Bundle.getParcelable()] is deprecated in [Build.VERSION_CODES.TIRAMISU].
 */
internal inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelable(key, T::class.java)
    else -> {
        @Suppress("DEPRECATION")
        getParcelable(key) as? T
    }
}
