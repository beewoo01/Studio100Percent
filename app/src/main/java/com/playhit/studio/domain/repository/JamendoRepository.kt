package com.playhit.studio.domain.repository

import com.playhit.studio.data.model.Track
import kotlinx.coroutines.flow.Flow

interface JamendoRepository {
    suspend fun searchTracks(
        search: String,
        limit: Int,
        offset: Int,
    ): Flow<List<Track>>

    suspend fun fetchTracks(
        clientId: String,
        format: String,
        limit: Int,
        fuzzytags : String,
        include : String,
    ) : List<Track>

}