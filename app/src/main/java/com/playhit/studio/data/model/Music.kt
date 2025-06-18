package com.playhit.studio.data.model

data class MusicContent(
    val music: Music,
    val comments: List<Comment>,
    val similarList : List<Music>
)

data class Music(
    val musicIdx : Int,
    val title : String,
    val content : String,
    val singer: String,
    val cover : String,
    val songUrl : String,
    val lyrics : String,
)

data class Comment(
    val user : User,
    val content : String,
)

data class User (
    val idx : Int,
    val name : String,
    val profileUrl : String,
)