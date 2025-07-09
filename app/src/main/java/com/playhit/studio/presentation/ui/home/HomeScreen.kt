package com.playhit.studio.presentation.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import com.playhit.studio.presentation.ui.home.detail.MusicDetail
import com.playhit.studio.presentation.ui.home.home.HomeContainer
import com.playhit.studio.utils.CircleProgress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.padding(horizontal = 20.dp),
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    when(viewModel.state) {
        HomeModelState.Idle -> CircleProgress(modifier = modifier.fillMaxSize())
        HomeModelState.Loading -> CircleProgress(modifier = modifier.fillMaxSize())
        HomeModelState.Loaded -> Box(
            modifier = modifier.fillMaxSize()
        ) {
            HomeContainer(
                list = viewModel.recommendList,
                exerciseTypes = viewModel.exerciseList,
                itemCallback = {
                    viewModel.setTrack(it)
                }
            )
        }

        HomeModelState.Detail -> MusicDetail(
            model = viewModel.selectedTrack
        )
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