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
    val results_count: Int,
    val next: String?
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
)