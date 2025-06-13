package com.playhit.studio.presentation.ui.join

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.presentation.components.DefaultAppBar
import com.playhit.studio.presentation.components.DefaultBlackButton
import com.playhit.studio.presentation.components.RoundedTextField
import com.playhit.studio.presentation.router.LocalNavScreenController
import com.playhit.studio.presentation.router.NavRoutes
import com.playhit.studio.presentation.theme.Studio100PercentTheme

@Composable
fun JoinScreen() {
    Studio100PercentTheme {
        JoinView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun JoinView(modifier: Modifier = Modifier) {

    val navController = LocalNavScreenController.current

    val idState = remember { mutableStateOf("") }
    val pwState = remember { mutableStateOf("") }

    Scaffold(
        containerColor = colorResource(id = R.color.textGrey),
        topBar = {
            DefaultAppBar(
                onClick = { navController.popBackStack() },
                title = "회원가입"
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 20.dp)) {

                RoundedTextField(
                    value = idState.value,
                    onValueChange = { idState.value = it },
                    hint = "아이디 입력"
                )

                Spacer(modifier = Modifier.height(27.dp))


                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "비밀번호 입력",
                )

                Spacer(modifier = Modifier.height(10.dp))

                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "비밀번호 확인",
                )

                Spacer(modifier = Modifier.height(29.dp))

                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "이메일 입력",
                )

                Spacer(modifier = Modifier.height(26.dp))

                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "생년월일 선택",
                )

                Spacer(modifier = Modifier.height(26.dp))

                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "생년월일 선택",
                )

                Spacer(modifier = Modifier.height(26.dp))
                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "전화번호 '-' 없이 입력",
                )
                Spacer(modifier = Modifier.height(26.dp))
                RoundedTextField(
                    value = pwState.value,
                    onValueChange = { pwState.value = it },
                    hint = "성별 선택",
                )

                Spacer(modifier = modifier.height(30.dp))

                DefaultBlackButton(title = "다음", onClick = {
                    navController.navigate(NavRoutes.Exercise.route) {
                        popUpTo(NavRoutes.Join.route){ inclusive = true }
                    }
                    //ExerciseScreen
                })



            }

        }
    )
}

@Preview
@Composable
fun JoinViewPreview() {
    JoinView()
}