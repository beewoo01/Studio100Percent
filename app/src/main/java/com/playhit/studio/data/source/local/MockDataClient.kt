package com.playhit.studio.data.source.local

import com.playhit.studio.data.model.Exercise
import javax.inject.Inject

class MockDataClient @Inject constructor(
    private val mockDataService: MockDataApiService
) {
    fun getRunningMockData(): List<Exercise> = mockDataService.getRunningMockData()
}

