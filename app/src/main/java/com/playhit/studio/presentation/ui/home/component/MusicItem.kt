package com.playhit.studio.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.playhit.studio.R
import com.playhit.studio.data.model.Track

@Preview
@Composable
fun MusicItem(modifier: Modifier = Modifier, model: Track? = null, clickCallback : (Track) -> Unit = {}) {
    Row(
        modifier = modifier
            .height(110.dp)
            .padding(
                vertical = 8.6.dp,
            ).clickable {
                if (model != null) {
                    clickCallback(model)
                }
            }
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(color = Color.White)
        ) {
            AsyncImage(
                model = "${model?.album_image}",
                contentDescription = "Album image",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = modifier.width(9.dp))

        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = modifier.width(18.dp))

            Text(
                model?.name ?: "",
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = modifier.width(7.dp))

            Text(
                model?.album_name ?: "",
                fontSize = 15.sp,
                color = colorResource(R.color.grey400),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = modifier.weight(1f))

            Text(
                model?.artist_name ?: "홍길동 (러닝)",
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}