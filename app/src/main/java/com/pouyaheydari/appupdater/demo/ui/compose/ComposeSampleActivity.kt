package com.pouyaheydari.appupdater.demo.ui.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pouyaheydari.appupdater.compose.ui.AndroidAppUpdater
import com.pouyaheydari.appupdater.compose.ui.models.UpdaterDialogData
import com.pouyaheydari.appupdater.core.model.Theme
import com.pouyaheydari.appupdater.demo.R
import com.pouyaheydari.appupdater.demo.ui.compose.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.demo.utils.directDownloadList
import com.pouyaheydari.appupdater.demo.utils.storeList
import com.pouyaheydari.appupdater.directdownload.R as directDownloadR

/**
 * To use the library in compose,
 * you only need to add dependencies to:
 * core and compose
 */
internal class ComposeSampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppUpdaterTheme {
                var state by rememberSaveable { mutableStateOf(false) }

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Button(onClick = { state = true }) {
                        Text(text = getString(R.string.show_compose_dialog))
                    }
                }
                if (state) {
                    AndroidAppUpdater(
                        UpdaterDialogData(
                            dialogTitle = stringResource(id = directDownloadR.string.appupdater_app_name),
                            dialogDescription = stringResource(id = R.string.library_description),
                            dividerText = stringResource(directDownloadR.string.appupdater_or),
                            storeList = storeList(this),
                            directDownloadList = directDownloadList(this),
                            theme = Theme.SYSTEM_DEFAULT,
                            onDismissRequested = { state = false },
                            errorWhileOpeningStoreCallback = {
                                Toast.makeText(this@ComposeSampleActivity, getString(R.string.store_is_not_installed, it), Toast.LENGTH_LONG).show()
                            },
                        ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidAppUpdaterTheme {
        AndroidAppUpdater(
            UpdaterDialogData(
                dialogTitle = stringResource(id = directDownloadR.string.appupdater_app_name),
                dialogDescription = stringResource(id = R.string.library_description),
                dividerText = stringResource(directDownloadR.string.appupdater_or),
                storeList = storeList(LocalContext.current),
                directDownloadList = directDownloadList(LocalContext.current),
                theme = Theme.DARK,
            ),
        )
    }
}