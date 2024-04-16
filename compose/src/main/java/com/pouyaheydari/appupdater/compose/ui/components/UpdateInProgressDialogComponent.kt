package com.pouyaheydari.appupdater.compose.ui.components

import android.graphics.Typeface
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R as coreR

internal const val DIALOG_TEST_TAG = "DialogTestTag"

@Composable
internal fun UpdateInProgressDialogComponent(
    modifier: Modifier = Modifier,
    isUpdateInProgress: Boolean = false,
    dialogTitle: String = "",
    dialogDescription: String = "",
    typeface: Typeface? = null,
) {
    AnimatedVisibility(visible = isUpdateInProgress) {
        Dialog(onDismissRequest = { /* Do nothing */ }) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .testTag(DIALOG_TEST_TAG),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                ) {
                    Text(
                        text = dialogTitle,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontFamily = typeface?.let { FontFamily(it) },
                    )
                    Text(
                        text = dialogDescription,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(all = 8.dp),
                        fontFamily = typeface?.let { FontFamily(it) },
                    )
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth().padding(all = 8.dp))
                }
            }
        }
    }
}

@PreviewLightDark
@PreviewFontScale
@PreviewScreenSizes
@Composable
private fun UpdateInProgressDialogPreview() {
    AndroidAppUpdaterTheme {
        UpdateInProgressDialogComponent(
            isUpdateInProgress = true,
            dialogTitle = stringResource(id = (coreR.string.appupdater_please_wait)),
            dialogDescription = stringResource(id = (coreR.string.appupdater_downloading_new_version)),
        )
    }
}
