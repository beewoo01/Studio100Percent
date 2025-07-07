package com.playhit.studio.data.repository
import android.util.Log
import com.playhit.studio.data.model.Track
import com.playhit.studio.data.model.TrackResponse
import com.playhit.studio.data.source.remote.JamendoAPIClient
import com.playhit.studio.domain.repository.JamendoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class JamendoRepositoryImpl @Inject constructor(
    private val jamendoAPIClient: JamendoAPIClient,
    @Named("jamendo_client_id") private val clientId: String
) : JamendoRepository {


    override suspend fun searchTracks(
        search: String,
        limit: Int,
        offset: Int,
    ): Flow<List<Track>> = flow {

        val data = jamendoAPIClient.searchTracks(
            clientId = clientId,
            limit = limit,
            offset = offset,
            search = search
        )

        Log.d("searchTracks", "data $data")
        emit(mapToTrack(data = data))
    }

    override suspend fun fetchTracks(
        format: String?,
        limit: Int?,
        fuzzytags: String,
        include: String
    ): List<Track> = withContext(Dispatchers.IO) {

        val data = jamendoAPIClient.fetchTracks(
            clientId = clientId,
            format = format,
            limit = limit,
            fuzzytags = fuzzytags,
            include = include,
        )

        Log.d("fetchTracks", "data $data")
        mapToTrack(data = data)
    }

    private fun mapToTrack(data: TrackResponse): List<Track> {
        return data.results.map {
            Log.d("Track", it.toString())
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
                audio = it.audio
            )
        }

    }
}

