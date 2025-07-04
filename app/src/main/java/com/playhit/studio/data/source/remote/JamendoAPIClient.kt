package com.playhit.studio.data.source.remote

import com.playhit.studio.data.model.TrackResponse
import javax.inject.Inject

class JamendoAPIClient @Inject constructor(
    private val jamendoAPIService: JamendoAPIService
) {

    suspend fun searchTracks(
        clientId: String,
        limit: Int,
        offset: Int,
        search: String
    ): TrackResponse {
        val response: TrackResponse = jamendoAPIService.searchTracks(
            clientId = clientId, limit = limit, offset = offset, search = search
        )
        return response

    }

    suspend fun fetchTracks(
        clientId: String,
        format: String,
        limit: Int,
        fuzzytags: String,
        include: String,
    ): TrackResponse {
        val response: TrackResponse = jamendoAPIService.fetchTracks(
            clientId = clientId,
            format = format,
            limit = limit,
            fuzzytags = fuzzytags,
            include = include
        )
        return response
    }
}
