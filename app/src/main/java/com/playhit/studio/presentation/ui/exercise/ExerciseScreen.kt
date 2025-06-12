package com.playhit.android.presentation.ui.exercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.playhit.android.R
import com.playhit.android.presentation.components.DefaultAppBar
import com.playhit.android.presentation.theme.Studio100PercentTheme


@Composable
fun ExerciseScreen() {
    Studio100PercentTheme {
        ExerciseView()
    }
}

@Composable
fun ExerciseView() {
    Scaffold(
        containerColor = colorResource(R.color.textGrey),
        topBar = {
            val navController = rememberNavController()

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
                    columns = GridCells.Adaptive(minSize = 120.dp),
                    contentPadding = PaddingValues(17.dp),
                    verticalArrangement = Arrangement.spacedBy(17.dp),
                    horizontalArrangement = Arrangement.spacedBy(17.dp)
                ) {
                    items(10) {
                        ExerciseGridItem()
                    }
                }

            }

        },
    )
}

@Preview
@Composable
fun ExercisePreView() {
    ExerciseView()
}

@Preview
@Composable
fun ExerciseGridItem() {
    Surface(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .background(color = Color.Blue)
            .border(
                border = BorderStroke(
                    width = 3.dp,
                    color = colorResource(R.color.yellow)
                )
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.exercise_walk),
                modifier = Modifier.size(width = 70.dp, height = 55.dp),
                contentDescription = "산책"
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text("산책", style = MaterialTheme.typography.bodyMedium)


        }
    }
}