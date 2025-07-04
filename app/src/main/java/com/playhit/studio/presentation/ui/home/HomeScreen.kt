package com.playhit.studio.presentation.ui.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.R
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import com.playhit.studio.presentation.ui.home.home.HomeContainer
import com.playhit.studio.presentation.ui.home.search.SearchResultContainer
import com.playhit.studio.utils.CircleProgress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.padding(horizontal = 20.dp),
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    var searchData by remember { mutableStateOf("") }

    val focusManger = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        Spacer(modifier = modifier.height(20.dp))
        CustomOutlinedTextField(
            value = searchData,
            onValueChange = { searchData = it },
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("HomeScreen", "onDone")
                    viewModel.search(search = searchData)
                    keyboardController?.hide()
                    focusManger.clearFocus()
                }
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            modifier = modifier,
            trailingIcon = {
                IconButton(
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = {
                        Log.d("G", "IconButton Click")
                        viewModel.search(search = searchData)
                        Log.d("ViewModelList", "${viewModel.list}")
                    }) {
                    Icon(
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }
        )

        Spacer(modifier = modifier.height(18.dp))

        Box(
            modifier = Modifier
                .padding()
                .fillMaxSize()
        ) {
            when (viewModel.state) {
                SearchViewModelState.Idle -> HomeContainer(list = viewModel.list)
                SearchViewModelState.Loading -> CircleProgress(modifier = modifier.fillMaxSize())
                SearchViewModelState.Typing -> Box(modifier = modifier)
                SearchViewModelState.Loaded -> SearchResultContainer()
            }
        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    Studio100PercentTheme {
        HomeScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        cursorBrush = Brush.verticalGradient(
            0.00f to Color.White,
            0.35f to Color.White,
        ),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        singleLine = true,
        textStyle = MaterialTheme.typography.labelMedium.copy(color = Color.White),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = remember { MutableInteractionSource() },
                label = { Text(label) },
                trailingIcon = trailingIcon,
                contentPadding = PaddingValues(horizontal = 25.dp),
                container = {
                    OutlinedTextFieldDefaults.Container(
                        enabled = true,
                        isError = false,
                        interactionSource = remember { MutableInteractionSource() },
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            disabledTextColor = Color.White,
                        )
                    )
                }
            )
        }
    )
}