package com.playhit.studio.domain.repository

import com.playhit.studio.data.model.Exercise

interface MockDataRepository {
    fun getExerciseMockData() : List<Exercise>
}