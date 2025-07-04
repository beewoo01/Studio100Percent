package com.playhit.studio.domain.usecase

import com.playhit.studio.data.model.Track
import com.playhit.studio.domain.repository.JamendoRepository
import javax.inject.Inject

class RecommendTrackUsecase @Inject constructor(
    val repository: JamendoRepository
) {
    suspend fun invoke(
        clientId: String,
        format: String,
        limit: Int,
        fuzzytags: String,
        include: String,
    ): List<Track> {
        return repository.fetchTracks(
            clientId = clientId,
            format = format,
            limit = limit,
            fuzzytags = fuzzytags,
            include = include,
        )
    }
}