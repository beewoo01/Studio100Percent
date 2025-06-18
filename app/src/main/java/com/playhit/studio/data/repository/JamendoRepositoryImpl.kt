package com.playhit.studio.data.repository

import android.util.Log
import com.playhit.studio.data.model.Track
import com.playhit.studio.data.model.TrackResponse
import com.playhit.studio.data.source.remote.JamendoAPIClient
import com.playhit.studio.domain.repository.JamendoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JamendoRepositoryImpl @Inject constructor(
    private val jamendoAPIClient: JamendoAPIClient
) : JamendoRepository {
    //https://api.jamendo.com/v3.0/tracks?client_id=b203ee59&format=json&limit=10&search=love
    override suspend fun searchTracks(
        search: String,
        limit: Int,
        offset: Int,
    ): Flow<List<Track>> = flow {
        val clientId = "b203ee59"

        val data = jamendoAPIClient.searchTracks(
            clientId = clientId,
            limit = limit,
            offset = offset,
            search = search
        )

        Log.d("searchTracks","data $data")

        emit(mapToTrack(data = data))
    }

    private fun mapToTrack(data: TrackResponse): List<Track> {
        return data.results.map {
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


    /*override fun getById(id: Int) : Flow<PokemonInfo> = flow {
        val data = pokedexApiClient.fetchPokemonDataById(id.toString())
        emit(mapToPokemonInfo(data))
    }


    override fun getByName(name: String): Flow<PokemonInfo> = flow {
        val data = pokedexApiClient.fetchPokemonDataByName(name.lowercase())
        emit(mapToPokemonInfo(data))
    }

    private fun mapToPokemonInfo(data: PokemonData) : PokemonInfo {
        return PokemonInfo(
            pokedexId = data.id,
            name = data.name.capitalizeFirstChar(),
            imageUrl = data.sprites.frontDefault,
            gifImageUrl = data.sprites.other.showdown.frontDefault,
            types = data.types.map {
                PokemonType.valueOf(it.type.name.capitalizeFirstChar())
            },
            height = data.height,
            weight = data.weight,
            abilities = data.abilities.map { it.ability.name }
        )
    }*/
}

