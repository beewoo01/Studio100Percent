package com.playhit.studio.data.source.local

import com.playhit.studio.data.mock.mockExerciseList
import com.playhit.studio.data.model.Exercise

class MockDataApiService {
    fun getRunningMockData(): List<Exercise> = mockExerciseList
}



/*
val mockUser = User(
    idx = 1,
    name = "Alice",
    profileUrl = "https://example.com/profiles/alice.jpg"
)

val mockComments = listOf(
    Comment(
        user = mockUser,
        content = "이 노래 진짜 좋아요!"
    ),
    Comment(
        user = User(
            idx = 2,
            name = "Bob",
            profileUrl = "https://example.com/profiles/bob.jpg"
        ),
        content = "가사가 정말 마음에 들어요."
    )
)

val mockSimilarList = listOf(
    Music(
        musicIdx = 2,
        title = "Similar Song 1",
        content = "비슷한 분위기의 곡입니다.",
        singer = "Other Singer",
        cover = "https://example.com/covers/similar1.jpg",
        songUrl = "https://example.com/songs/similar1.mp3",
        lyrics = "이건 비슷한 노래의 가사입니다..."
    ),
    Music(
        musicIdx = 3,
        title = "Similar Song 2",
        content = "이 노래도 한번 들어보세요.",
        singer = "Another Singer",
        cover = "https://example.com/covers/similar2.jpg",
        songUrl = "https://example.com/songs/similar2.mp3",
        lyrics = "비슷한 노래 2의 가사입니다..."
    )
)

val mockMusic = Music(
    musicIdx = 1,
    title = "My Favorite Song",
    content = "이 노래는 감성이 넘치는 곡입니다.",
    singer = "Awesome Singer",
    cover = "https://example.com/covers/main.jpg",
    songUrl = "https://example.com/songs/main.mp3",
    lyrics = "여기는 메인 곡의 가사입니다..."
)

val mockMusicContent = MusicContent(
    music = mockMusic,
    comments = mockComments,
    similarList = mockSimilarList
)*/

