package com.playhit.studio.presentation.ui.exercise

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playhit.studio.data.model.Exercise
import com.playhit.studio.domain.usecase.ExerciseUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class ViewModelState {
    Loading,
    Idle,
}

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: ExerciseUsecase
) : ViewModel() {

    var list by mutableStateOf<List<Exercise>>(emptyList())
        private set

    var state by mutableStateOf(ViewModelState.Idle)
        private set


    fun fetchExercise() {
        viewModelScope.launch {
            state = ViewModelState.Loading

            useCase.execute().run {
                if(isNotEmpty()) {
                    list = this@run
                }
            }

            state = ViewModelState.Idle

        }

    }
}