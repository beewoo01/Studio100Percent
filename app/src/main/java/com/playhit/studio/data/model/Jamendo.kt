package com.playhit.studio.data.model

import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class TrackResponse(
    val headers: TrackHeaders,
    val results: List<Track>
)

@Serializable
data class TrackHeaders(
    val status: String,
    val code: Int,
    val error_message : String,
    val warnings : String = "",
    val results_count: Int = 0,
    val next: String? = null
)

@Serializable
data class Track(
    val id : String,
    val name : String,
    val duration : Int,
    val artist_name : String,
    val album_name : String,
    val album_id : String,
    val position : Int,
    val releasedate : String,
    val album_image : String,
    val audio : String,
    val lyrics : String = "",
    val comments : List<TrackComment> = emptyList()
)

@Serializable
data class TrackComment(
    val commentId : Int,
    val comment : String,
    val user : User,
    val replies : List<TrackComment> = emptyList()
)


@Serializable
data class User(
    val userId : Int,
    val userName : String,
    val userProfile : String,
)