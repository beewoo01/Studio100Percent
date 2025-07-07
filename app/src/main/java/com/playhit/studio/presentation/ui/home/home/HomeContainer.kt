package com.playhit.studio.presentation.ui.home.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.playhit.studio.R
import com.playhit.studio.data.model.Track
import com.playhit.studio.presentation.theme.Studio100PercentTheme


@Composable
fun HomeContainer(
    modifier: Modifier = Modifier,
    list: List<Track> = listOf()
) {
    Column(modifier = modifier.fillMaxSize()) {
        Row {
            Spacer(modifier = modifier.weight(1f))
            TextButton(
                onClick = {

                }
            ) {
                Text(
                    "더보기 +",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = Color.White
                    )
                )
            }
        }

        Spacer(modifier = modifier.height(9.dp))
        Box(
            modifier = modifier
                .weight(1f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            LazyColumn(modifier = modifier) {
                //items(list.size) { index ->
                item {
                    HorizontalDivider(
                        color = colorResource(R.color.border),
                        modifier = modifier.padding(horizontal = 20.dp)
                    )
                }
                items(list.size) { index ->
                    HomeMusicItem(modifier = modifier, model = list[index])
                    HorizontalDivider(
                        color = colorResource(R.color.border),
                        modifier = modifier.padding(horizontal = 20.dp)
                    )
                    //HomeMusicItem(model = list[index])
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeMusicItem(modifier: Modifier = Modifier, model: Track? = null) {
    Row(
        modifier = modifier
            .height(110.dp)
            .padding(
                vertical = 8.6.dp,
                horizontal = 20.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(color = Color.White)
        ) {
            AsyncImage(
                model = "${model?.album_image}",
                contentDescription = "Network image",
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
                model?.name ?: "sample",
                fontSize = 14.sp,
                color = Color.White,
            )

            Spacer(modifier = modifier.width(7.dp))

            Text(
                model?.artist_name ?: "Sample track content",
                fontSize = 15.sp,
                color = colorResource(R.color.grey400),
            )

            Spacer(modifier = modifier.weight(1f))

            Text(
                model?.artist_name ?: "홍길동 (러닝)",
                fontSize = 14.sp,
                color = Color.White,
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun HomePreview() {
    Studio100PercentTheme {
        HomeContainer(modifier = Modifier.padding(horizontal = 0.dp))
    }
}