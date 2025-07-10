package com.playhit.studio.data.repository

import com.playhit.studio.data.model.Exercise
import com.playhit.studio.data.source.local.MockDataClient
import com.playhit.studio.domain.repository.MockDataRepository
import javax.inject.Inject

class MockDataRepositoryImpl @Inject constructor(
    private val mockDataClient: MockDataClient
) : MockDataRepository {

    override fun getExerciseMockData(): List<Exercise> =
        mockDataClient.getRunningMockData()
}