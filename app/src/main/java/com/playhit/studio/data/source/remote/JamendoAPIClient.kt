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
    ): TrackResponse = jamendoAPIService.searchTracks(
        clientId = clientId, limit = limit, offset = offset, search = search
    )


}
