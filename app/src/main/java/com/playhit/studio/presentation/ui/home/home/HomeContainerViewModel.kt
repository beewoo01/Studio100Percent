package com.playhit.studio.presentation.ui.home.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.playhit.studio.data.model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class HomeContainerState {
    Idle
}

@HiltViewModel
class HomeContainerViewModel @Inject constructor(

) : ViewModel() {
    var list by mutableStateOf<List<Track>>(emptyList())
        private set

    var state by mutableStateOf(HomeContainerState.Idle)
        private set


}