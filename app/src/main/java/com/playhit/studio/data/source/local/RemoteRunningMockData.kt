package com.playhit.android.data.source.local

import com.playhit.android.data.model.ExerciseDTO
import com.playhit.android.data.model.ExerciseType

class RemoteRunningMockData {
    fun getRunningMockData(): List<ExerciseDTO> = mockExerciseList

}


val mockExerciseList = listOf(
    ExerciseDTO(id = 1, type = ExerciseType.WALK),
    ExerciseDTO(id = 2, type = ExerciseType.RUNNING),
    ExerciseDTO(id = 3, type = ExerciseType.YOGA),
    ExerciseDTO(id = 4, type = ExerciseType.RUNNING_MACHINE),
    ExerciseDTO(id = 5, type = ExerciseType.BODY_WEIGHT),
    ExerciseDTO(id = 6, type = ExerciseType.BICYCLE),
    ExerciseDTO(id = 7, type = ExerciseType.WEIGHT_TRAINING),
    ExerciseDTO(id = 8, type = ExerciseType.SWIM)
)