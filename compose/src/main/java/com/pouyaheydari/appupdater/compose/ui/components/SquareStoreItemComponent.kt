package com.pouyaheydari.appupdater.compose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R

@Composable
internal fun SquareStoreItemComponent(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    onClickListener: () -> Unit = {},
) {
    Column(
        modifier = modifier.clickable { onClickListener() },
        horizontalAlignment = CenterHorizontally,
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        SquareStoreItemComponent(title = "Google Play", icon = R.drawable.appupdater_ic_google_play)
    }
}
