package com.playhit.studio.domain.usecase

import com.playhit.studio.data.model.Track
import com.playhit.studio.domain.repository.JamendoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUsecase @Inject constructor(
    val repository: JamendoRepository
) {
    suspend fun search(search: String, limit : Int, offset: Int): Flow<List<Track>> {
        return repository.searchTracks(
            search = search,
            limit = limit,
            offset = offset
        )
    }
}