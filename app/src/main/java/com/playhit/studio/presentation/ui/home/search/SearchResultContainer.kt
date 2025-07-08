package com.playhit.studio.presentation.ui.home.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.R
import com.playhit.studio.presentation.components.LogoTitleBar
import com.playhit.studio.presentation.ui.home.HomeScreenViewModel
import com.playhit.studio.presentation.ui.home.component.MusicItem

@Preview
@Composable
fun SearchResultContainer(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text("검색결과 ${viewModel.searchList.count()}개")
        Spacer(modifier = modifier.height(8.dp))
        LazyColumn(modifier = modifier.weight(2f)) {
            item {
                HorizontalDivider(
                    color = colorResource(R.color.border),
                )
            }
            items(viewModel.searchList.size) {
                MusicItem(
                    model = viewModel.searchList[it]
                )
            }
        }

        Spacer(modifier = modifier.height(27.dp))

        LogoTitleBar(modifier = modifier, title = "비슷한 노래")

        Spacer(modifier = modifier.height(13.dp))

        LazyColumn(modifier = modifier.weight(1f)) {
            item {
                HorizontalDivider(
                    color = colorResource(R.color.border),
                )
            }
            items(viewModel.searchList.size) {
                MusicItem(
                    model = viewModel.searchList[it]
                )
            }
        }

    }


}