package com.playhit.studio.presentation.ui.main

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


enum class SearchState {
    Idle,
    Loading,
    Typing,
    Loaded,
}

@HiltViewModel
class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val searchUsecase: SearchUsecase,
) : ViewModel(){

    private val limit = 20

    private var offset = 0

    var searchList by mutableStateOf<List<Track>>(emptyList())
        private set

    var state by mutableStateOf(SearchState.Idle)
        private set


    fun typing() {
        Log.d("HomeScreenViewModel", "typing")
        state = SearchState.Typing
    }


    fun search(search: String) {
        Log.d("HomeScreenViewModel", "search")
        viewModelScope.launch {
            state = SearchState.Loading

            searchUsecase.search(
                search = search,
                limit = limit,
                offset = offset
            ).collect {
                searchList = it
                offset += limit
                state = SearchState.Loaded
                Log.d("SearchViewModel search", "search $searchList")
            }
        }
    }

}