package com.playhit.studio.data.mock

import com.playhit.studio.data.model.Exercise
import com.playhit.studio.data.model.ExerciseType
import com.playhit.studio.data.model.TrackComment
import com.playhit.studio.data.model.User

val mockExerciseList = listOf(
    Exercise(id = 1, type = ExerciseType.WALK),
    Exercise(id = 2, type = ExerciseType.RUNNING),
    Exercise(id = 3, type = ExerciseType.YOGA),
    Exercise(id = 4, type = ExerciseType.RUNNING_MACHINE),
    Exercise(id = 5, type = ExerciseType.BODY_WEIGHT),
    Exercise(id = 6, type = ExerciseType.BICYCLE),
    Exercise(id = 7, type = ExerciseType.WEIGHT_TRAINING),
    Exercise(id = 8, type = ExerciseType.SWIM)
)

val mockUsers = listOf(
    User(userId = 1, userName = "Alice", userProfile = "https://foo.com/alice.png"),
    User(userId = 2, userName = "Bob",   userProfile = "https://foo.com/bob.png"),
)

val mockComments: List<TrackComment> = listOf(
    TrackComment(
        commentId = 100,
        comment   = "이 곡 진짜 좋네요!",
        user      = mockUsers[0],
        replies   = listOf(
            TrackComment(
                commentId = 101,
                comment   = "222 공감합니다 😊",
                user      = mockUsers[1]
            )
        )
    ),
    TrackComment(
        commentId = 102,
        comment   = "0:42 에서 드롭 미쳤다…",
        user      = mockUsers[1]
    )
)

val mockMusicContentJson = """
{
  "music": {
    "musicIdx": 1,
    "title": "My Favorite Song",
    "content": "이 노래는 감성이 넘치는 곡입니다.",
    "singer": "Awesome Singer",
    "cover": "https://example.com/covers/main.jpg",
    "songUrl": "https://example.com/songs/main.mp3",
    "lyrics": "여기는 메인 곡의 가사입니다..."
  },
  "comments": [
    {
      "user": {
        "idx": 1,
        "name": "Alice",
        "profileUrl": "https://example.com/profiles/alice.jpg"
      },
      "content": "이 노래 진짜 좋아요!"
    },
    {
      "user": {
        "idx": 2,
        "name": "Bob",
        "profileUrl": "https://example.com/profiles/bob.jpg"
      },
      "content": "가사가 정말 마음에 들어요."
    }
  ],
  "similarList": [
    {
      "musicIdx": 2,
      "title": "Similar Song 1",
      "content": "비슷한 분위기의 곡입니다.",
      "singer": "Other Singer",
      "cover": "https://example.com/covers/similar1.jpg",
      "songUrl": "https://example.com/songs/similar1.mp3",
      "lyrics": "이건 비슷한 노래의 가사입니다..."
    },
    {
      "musicIdx": 3,
      "title": "Similar Song 2",
      "content": "이 노래도 한번 들어보세요.",
      "singer": "Another Singer",
      "cover": "https://example.com/covers/similar2.jpg",
      "songUrl": "https://example.com/songs/similar2.mp3",
      "lyrics": "비슷한 노래 2의 가사입니다..."
    }
  ]
}
""".trimIndent()
