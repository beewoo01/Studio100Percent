package com.playhit.studio.presentation.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playhit.studio.data.model.Track
import com.playhit.studio.domain.usecase.SearchUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class SearchViewModelState {
    Idle,
    Loading,
    Typing,
    Loaded,
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val usecase: SearchUsecase
) : ViewModel() {

    var list by mutableStateOf<List<Track>>(emptyList())
        private set

    var state by mutableStateOf(SearchViewModelState.Idle)
        private set

    var needLoadMore by mutableStateOf(true)
        private set

    private val limit = 20

    private var offset = 0

    fun typing() {
        Log.d("HomeScreenViewModel", "typing")
        state = SearchViewModelState.Typing
    }

    fun search(search: String) {
        Log.d("HomeScreenViewModel", "search")
        viewModelScope.launch {
            state = SearchViewModelState.Loading

            usecase.search(
                search = search,
                limit = limit,
                offset = offset
            ).collect {
                list = it
                offset += limit
                state = SearchViewModelState.Loaded
                Log.d("SearchViewModel search","search $list")
            }
        }
    }
}
