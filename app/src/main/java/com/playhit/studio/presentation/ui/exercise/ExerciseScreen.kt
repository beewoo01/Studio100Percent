package com.playhit.studio.presentation.ui.exercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.R
import com.playhit.studio.data.model.Exercise
import com.playhit.studio.presentation.components.DefaultAppBar
import com.playhit.studio.presentation.components.DefaultBlackButton
import com.playhit.studio.presentation.router.LocalNavScreenController


@Composable
fun ExerciseScreen(
    viewModel: ExerciseViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.fetchExercise()
    }

    if (viewModel.list.isEmpty() &&
        viewModel.state == ViewModelState.Loading
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator(
                modifier = Modifier.size(35.dp)
            )

        }
    } else {
        ExerciseView(viewModel.list)
    }


}

@Composable
fun ExerciseView(
    list: List<Exercise>
) {
    var selectedExercises by remember { mutableStateOf(setOf<Int>()) }
    val navController = LocalNavScreenController.current

    Scaffold(
        containerColor = colorResource(R.color.textGrey),
        topBar = {
            DefaultAppBar(
                onClick = {
                    navController.popBackStack()
                },
                title = "선호하는 운동"
            )
        },
        content = { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "* 선호하는 운동을 다중선택 가능합니다 *",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(14.dp))

                LazyVerticalGrid(
                    modifier = Modifier.weight(1f),
                    columns = GridCells.Adaptive(minSize = 120.dp),
                    contentPadding = PaddingValues(17.dp),
                    verticalArrangement = Arrangement.spacedBy(17.dp),
                    horizontalArrangement = Arrangement.spacedBy(17.dp)
                ) {

                    items(list, key = { it.id }) { exerciseInfo ->
                        val isSelected = selectedExercises.contains(exerciseInfo.id)

                        ExerciseGridItem(
                            exercise = exerciseInfo,
                            onTapState = isSelected,
                            modifier = Modifier.clickable {
                                selectedExercises = if (isSelected) {
                                    selectedExercises - exerciseInfo.id
                                } else {
                                    selectedExercises + exerciseInfo.id
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                DefaultBlackButton(
                    title = "가입하기",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    onClick = {
                        navController.popBackStack()
                    }
                )

                Spacer(modifier = Modifier.height(14.dp))

            }

        },
    )
}

@Preview
@Composable
fun ExercisePreView() {
    ExerciseView(list = listOf())
}

@Composable
fun ExerciseGridItem(
    modifier: Modifier = Modifier,
    exercise: Exercise,
    onTapState: Boolean = false,
) {
    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    width = 3.dp,
                    color = colorResource(if (onTapState) R.color.yellow else R.color.white),
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
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