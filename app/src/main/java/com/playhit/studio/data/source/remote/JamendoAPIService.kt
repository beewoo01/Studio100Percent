package com.playhit.studio.data.source.remote

import com.playhit.studio.data.model.TrackResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JamendoAPIService {
    //아아디 : 네이버  | 비번 : 6자리
    @GET("tracks/")
    suspend fun searchTracks(
        @Query("client_id") clientId: String,
        @Query("format") format: String = "json",
        @Query("limit") limit: Int = 10,
        @Query("offset") offset : Int = 0,
        @Query("search") search : String
    ) : TrackResponse

    @GET("tracks/")
    suspend fun fetchTracks(
        @Query("client_id") clientId: String,
        @Query("format") format: String = "json",
        @Query("limit") limit: Int = 10,
        @Query("fuzzytags") fuzzytags : String = "rock",
        @Query("include") include : String = "musicinfo"
    ) : TrackResponse

}