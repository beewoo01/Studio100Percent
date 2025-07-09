package com.playhit.studio.presentation.ui.home.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.playhit.studio.data.model.TrackComment

@Preview
@Composable
fun CommentsContainer(trackComments: List<TrackComment> = emptyList()) {
    LazyColumn {

    }
}

@Preview
@Composable
fun CommentContainer(trackComment: TrackComment? = null) {
    Row {
        AsyncImage(
            model = trackComment?.user?.userProfile ?: "",
            contentDescription = null,
            modifier = Modifier
                .size(33.dp)
                .clip(CircleShape)
        )

        Spacer(Modifier.width(9.dp))

        Column() {
            Text(trackComment?.user?.userName ?: "")
            Text(trackComment?.comment ?: "")
        }
    }
}