package com.playhit.studio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R

@Preview
@Composable
fun LogoTitleBar(modifier: Modifier = Modifier, title: String = "") {
    Row(
        modifier = modifier
    ) {
        Image(
            painterResource(R.drawable.white_logo),
            modifier = Modifier.size(16.dp),
            contentDescription = "logo",
        )

        Spacer(modifier = Modifier.width(width = 6.dp))

        Text(
            title,
            style = MaterialTheme.typography.bodyMedium
        )

    }
}