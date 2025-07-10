package com.playhit.studio.presentation.ui.home.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.playhit.studio.R
import com.playhit.studio.data.model.TrackComment

@Preview
@Composable
fun CommentsContainer(trackComments: List<TrackComment> = emptyList()) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(trackComments.size) {
            CommentContainer(trackComment = trackComments[it])
        }
    }
}

@Preview
@Composable
fun CommentContainer(trackComment: TrackComment? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            /*AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(trackComment?.user?.userProfile ?: "")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(R.drawable.placeholder_profile), // 로딩 중
                error = painterResource(R.drawable.error_profile),             // 에러 시
                modifier = Modifier
                    .size(33.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )*/
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(trackComment?.user?.userProfile ?: "")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                //placeholder = colorResource(R.color.white),
                modifier = Modifier
                    .size(33.dp)
                    .clip(CircleShape)
                    .background(color = Color.Red)
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(Modifier.width(9.dp))

        Column(
            modifier = Modifier.background(color = Color.Yellow),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                trackComment?.user?.userName ?: "뮤직",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = colorResource(
                        R.color.grey200
                    ),
                )
            )
            Text(
                trackComment?.comment ?: "리듬, 가사",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = colorResource(
                        R.color.white
                    ),
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column {

            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_more_vert),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}