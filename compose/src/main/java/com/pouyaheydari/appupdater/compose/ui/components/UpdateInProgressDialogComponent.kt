package com.pouyaheydari.appupdater.compose.ui.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * Update in progress dialog is not dismissible by the user.
 */
@Composable
internal fun UpdateInProgressDialogComponent() {
    Dialog(onDismissRequest = { /* Do nothing */ }) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp),
            ) {
                Text(
                    text = stringResource(id = (coreR.string.appupdater_please_wait)),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
                Text(
                    text = stringResource(id = (coreR.string.appupdater_downloading_new_version)),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(all = 8.dp),
                )
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun UpdateInProgressDialogPreview() {
    AndroidAppUpdaterTheme {
        UpdateInProgressDialogComponent()
    }
}
