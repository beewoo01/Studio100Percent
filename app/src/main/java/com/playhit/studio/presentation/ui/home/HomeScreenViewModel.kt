package com.playhit.studio.presentation.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playhit.studio.data.model.Exercise
import com.playhit.studio.data.model.Track
import com.playhit.studio.domain.usecase.ExerciseUsecase
import com.playhit.studio.domain.usecase.RecommendTrackUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class HomeModelState {
    Idle,
    Loading,
    Loaded,
    Detail
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val recommendUsecase: RecommendTrackUsecase,
    private val exerciseUsecase: ExerciseUsecase
) : ViewModel() {

    var state by mutableStateOf(HomeModelState.Idle)
        private set

    var needLoadMore by mutableStateOf(true)
        private set


    var recommendList by mutableStateOf<List<Track>>(emptyList())
        private set

    var exerciseList by mutableStateOf<List<Exercise>>(emptyList())
        private set


    var selectedTrack by mutableStateOf<Track?>(null)
        private set

    private val limit = 20

    private var offset = 0


    init {
        execute()
    }


    fun setTrack(track : Track) {
        selectedTrack = track
        state = HomeModelState.Detail
    }



    private fun execute() {
        state = HomeModelState.Loaded

        viewModelScope.launch {
            recommendList = recommendUsecase.invoke(
                limit = limit,
                fuzzytags = "rock",
                include = "musicinfo"
            )

            exerciseList = exerciseUsecase.execute()

            state = HomeModelState.Loaded
        }
    }


}
