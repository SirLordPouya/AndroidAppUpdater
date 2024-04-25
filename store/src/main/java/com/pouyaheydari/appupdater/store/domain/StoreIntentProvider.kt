package com.pouyaheydari.appupdater.store.domain

import android.content.Intent
import android.net.Uri

internal object StoreIntentProvider {
    internal class Builder(private val uriString: String) {
        private var storePackageName: String? = null

        fun withPackage(storePackageName: String): Builder {
            require(storePackageName.isNotBlank()) { "Store's package name most not be empty" }
            this.storePackageName = storePackageName
            return this
        }

        fun build(): Intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriString)).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            storePackageName?.takeIf { it.isNotBlank() }?.let { setPackage(it) }
        }
    }
}
