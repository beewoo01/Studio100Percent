package com.playhit.studio.data.model

import com.playhit.studio.R

data class Exercise(
    val id: Int,
    val type: ExerciseType
)

enum class ExerciseType(
    val exerciseName: String,
    val image: Int
) {
    WALK(
        exerciseName = "산책",
        image = R.drawable.exercise_walk
    ),

    RUNNING(
        exerciseName = "러닝",
        image = R.drawable.exercise_running
    ),

    YOGA(
        exerciseName = "요가",
        image = R.drawable.exercise_yoga
    ),

    RUNNING_MACHINE(
        exerciseName = "러닝머신",
        image = R.drawable.exercise_runnig_machine
    ),

    BODY_WEIGHT(
        exerciseName = "맨몸운동",
        image = R.drawable.exercise_body_weight
    ),

    BICYCLE(
        exerciseName = "자전거",
        image = R.drawable.exercise_bicycle
    ),

    WEIGHT_TRAINING(
        exerciseName = "헬스",
        image = R.drawable.exercise_weight_training
    ),

    SWIM(
        exerciseName = "수영",
        image = R.drawable.exercise_swim
    );

    companion object {
        fun fromName(name: String): ExerciseType? = entries.find { it.exerciseName == name }
    }
}