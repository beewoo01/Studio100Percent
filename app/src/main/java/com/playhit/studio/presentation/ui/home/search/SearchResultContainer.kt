package com.playhit.studio.presentation.ui.home.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.presentation.ui.home.HomeScreenViewModel

@Preview
@Composable
fun SearchResultContainer(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column(modifier = modifier) {
        Text("검색결과 ${viewModel.list.count()}개")
    }
}