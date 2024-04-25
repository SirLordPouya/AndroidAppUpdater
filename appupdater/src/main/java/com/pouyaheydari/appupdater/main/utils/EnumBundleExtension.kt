package com.pouyaheydari.appupdater.main.utils

import android.os.Bundle

/**
 * A function to put enums in bundles
 */
internal fun Bundle.putEnum(key: String, enum: Enum<*>) {
    this.putInt(key, enum.ordinal)
}

/**
 * A function to retrieve enums from bundles
 */
internal inline fun <reified T : Enum<T>> Bundle.getEnum(key: String): T {
    return enumValues<T>()[getInt(key, 0)]
}
