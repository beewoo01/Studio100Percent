package com.playhit.studio.data.source.local

import com.playhit.studio.data.model.Exercise
import com.playhit.studio.data.model.ExerciseType

class MockDataApiService {
    fun getRunningMockData(): List<Exercise> = mockExerciseList
}


private val mockExerciseList = listOf(
    Exercise(id = 1, type = ExerciseType.WALK),
    Exercise(id = 2, type = ExerciseType.RUNNING),
    Exercise(id = 3, type = ExerciseType.YOGA),
    Exercise(id = 4, type = ExerciseType.RUNNING_MACHINE),
    Exercise(id = 5, type = ExerciseType.BODY_WEIGHT),
    Exercise(id = 6, type = ExerciseType.BICYCLE),
    Exercise(id = 7, type = ExerciseType.WEIGHT_TRAINING),
    Exercise(id = 8, type = ExerciseType.SWIM)
)