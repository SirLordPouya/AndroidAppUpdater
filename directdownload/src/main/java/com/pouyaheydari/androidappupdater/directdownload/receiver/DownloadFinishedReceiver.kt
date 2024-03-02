package com.pouyaheydari.androidappupdater.directdownload.receiver

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.pouyaheydari.androidappupdater.directdownload.domain.GetRequestIdInteractor
import com.pouyaheydari.androidappupdater.directdownload.domain.SetIsUpdateInProgress
import com.pouyaheydari.androidappupdater.directdownload.utils.getExistingApk
import com.pouyaheydari.androidappupdater.directdownload.utils.installAPK
import com.pouyaheydari.appupdater.core.R
import com.pouyaheydari.appupdater.core.utils.ANDROID_APP_UPDATER_DEBUG_TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Receives when download is finished and opens the install dialog
 */
internal class DownloadFinishedReceiver : BroadcastReceiver() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val getRequestIdInteractor by lazy { GetRequestIdInteractor() }
    private val setIsUpdateInProgress by lazy { SetIsUpdateInProgress() }

    /**
     * To show install page when apk got downloaded successfully
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == DownloadManager.ACTION_DOWNLOAD_COMPLETE) {
            val referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

            // if downloaded file is our apk
            if (referenceId == getRequestIdInteractor()) {
                context?.let {
                    hideUpdateInProgress()
                    verifyDownloadedApkExists(it)
                }
            }
        }
    }

    private fun hideUpdateInProgress() {
        coroutineScope.launch {
            setIsUpdateInProgress(false)
        }
    }

    private fun verifyDownloadedApkExists(context: Context) {
        val existingApk = context.getExistingApk()
        if (!existingApk.exists()) {
            Log.e(ANDROID_APP_UPDATER_DEBUG_TAG, context.getString(R.string.appupdater_couldnt_find_downloaded_file))
        } else {
            installAPK(context, existingApk, Build.VERSION.SDK_INT)
        }
    }
}
