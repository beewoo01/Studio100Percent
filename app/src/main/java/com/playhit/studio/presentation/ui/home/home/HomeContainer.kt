package com.playhit.studio.presentation.ui.home.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.data.model.Exercise
import com.playhit.studio.data.model.ExerciseType
import com.playhit.studio.data.model.Track
import com.playhit.studio.presentation.components.LogoTitleBar
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import com.playhit.studio.presentation.ui.home.component.MusicItem


@Composable
fun HomeContainer(
    modifier: Modifier = Modifier,
    list: List<Track> = listOf(),
    exerciseTypes: List<Exercise> = listOf(),
    itemCallback: (Track) -> Unit = {}
) {

    Column(modifier = modifier.fillMaxSize()) {
        Row {
            Spacer(modifier = Modifier.weight(1f))
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

        Spacer(modifier = Modifier.height(9.dp))
        Box(
            modifier = Modifier
                //.padding(horizontal = 20.dp)
                .weight(1f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            LazyColumn(modifier = Modifier) {
                item {
                    HorizontalDivider(
                        color = colorResource(R.color.border),
                    )
                }
                items(list.size) { index ->
                    MusicItem(
                        modifier = Modifier,
                        model = list[index],
                        clickCallback = {
                            itemCallback(list[index])
                        }
                    )
                    HorizontalDivider(
                        color = colorResource(R.color.border),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(19.dp))

        LogoTitleBar(modifier = Modifier, title = "운동별 추천")

        Spacer(modifier = Modifier.height(20.5.dp))

        LazyRow(
            modifier = Modifier.height(120.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(exerciseTypes.size) {
                ExerciseItem(
                    modifier = modifier,
                    exercise = exerciseTypes[it]
                )
            }

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

@Preview
@Composable
fun ExerciseItem(
    modifier: Modifier = Modifier,
    exercise: Exercise = Exercise(
        id = 0,
        type = ExerciseType.WALK
    ),
    itemCallback: (Exercise) -> Unit = {}
) {
    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { itemCallback(exercise) },
        color = colorResource(R.color.grey400),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(exercise.type.image),
                modifier = Modifier.size(width = 70.dp, height = 55.dp),
                contentDescription = exercise.type.exerciseName
            )

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                exercise.type.exerciseName,
                style = MaterialTheme.typography.bodyMedium
            )


        }
    }

}