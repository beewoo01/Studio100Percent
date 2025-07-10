package com.playhit.studio.data.source.remote

import android.util.Log
import com.playhit.studio.data.mock.mockComments
import com.playhit.studio.data.model.Track
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
        format: String?,
        limit: Int?,
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

        val results: List<Track> = response.results.toList().map {
            Track(
                id = it.id,
                name = it.name,
                duration = it.duration,
                artist_name = it.artist_name,
                album_name = it.album_name,
                album_id = it.album_id,
                position = it.position,
                releasedate = it.releasedate,
                album_image = it.album_image,
                audio = it.audio,
                comments = mockComments
            )
        }

        Log.d("fetchTracks", "results is $results")

        return TrackResponse(
            headers = response.headers,
            results = results
        )
    }
}
