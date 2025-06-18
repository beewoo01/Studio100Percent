package com.playhit.studio.presentation.ui.home.search

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
}

@HiltViewModel
class SearchViewModel @Inject constructor(
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

    fun search(search: String) {
        viewModelScope.launch {
            state = SearchViewModelState.Loading

            usecase.search(
                search = search,
                limit = limit,
                offset = offset
            ).collect {
                list = it
                offset += limit
                state = SearchViewModelState.Idle
                Log.d("SearchViewModel search","search $list")
            }
        }
    }
}
