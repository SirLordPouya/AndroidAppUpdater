package com.pouyaheydari.appupdater.core.utils

import android.content.Intent
import android.net.Uri

internal object AndroidIntentBuilder {
    private var uri: Uri? = null
    private var packageName: String? = null

    fun addUriString(uriString: String): AndroidIntentBuilder {
        uri = Uri.parse(uriString)
        return this
    }

    fun addPackage(packageName: String): AndroidIntentBuilder {
        this.packageName = packageName
        return this
    }

    fun build(): Intent {
        requireNotNull(uri) { "URI must be set before calling build()" }

        return Intent(Intent.ACTION_VIEW, uri).apply {
            packageName?.takeIf { it.isNotBlank() }?.let { setPackage(it) }
        }
    }
}
