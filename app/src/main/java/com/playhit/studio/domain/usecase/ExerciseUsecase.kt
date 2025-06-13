package com.playhit.studio.domain.usecase

import com.playhit.studio.data.model.Exercise
import com.playhit.studio.domain.repository.MockDataRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class ExerciseUsecase @Inject constructor(
    val repository: MockDataRepository
) {
    suspend fun execute(): List<Exercise> {
        return repository.getExerciseMockData()
    }

}