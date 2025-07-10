package com.playhit.studio.domain.usecase

import android.util.Log
import com.playhit.studio.data.model.Track
import com.playhit.studio.domain.repository.JamendoRepository
import javax.inject.Inject

class RecommendTrackUsecase @Inject constructor(
    val repository: JamendoRepository
) {
    suspend operator fun invoke(
        format: String? = null,
        limit: Int?  = null,
        fuzzytags: String,
        include: String,
    ): List<Track> {
        Log.d("RecommendTrackUsecase","invoke")
        return repository.fetchTracks(
            format = format,
            limit = limit,
            fuzzytags = fuzzytags,
            include = include,
        )
    }
}
