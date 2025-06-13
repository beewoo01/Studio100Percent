package com.playhit.studio.presentation.ui.find

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playhit.studio.R
import com.playhit.studio.presentation.components.CustomDialog
import com.playhit.studio.presentation.components.DefaultAppBar
import com.playhit.studio.presentation.components.DefaultBlackButton
import com.playhit.studio.presentation.components.RoundedTextField
import com.playhit.studio.presentation.router.LocalNavScreenController
import kotlinx.coroutines.launch


@SuppressLint("MutableCollectionMutableState")
@Composable
fun FindMainScreen(
    modifier: Modifier = Modifier,
    initialState: Int = 0,
    viewModel: FindMainViewModel = hiltViewModel()
) {
    val tabTitles = listOf("아이디 찾기", "비밀번호 찾기")
    var selectedTabIndex by remember { mutableIntStateOf(initialState) }
    val navController = LocalNavScreenController.current

    var showDialog by remember { mutableStateOf(false) }
    val dialogResult by remember { mutableStateOf(mutableMapOf<String, Any>()) }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        DefaultAppBar(
            onClick = { navController.popBackStack() },
            title = "아이디 찾기 · 비밀번호 찾기"
        )
    }) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = colorResource(R.color.textGrey))
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.black),
                indicator = {
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(it[selectedTabIndex]),
                        color = Color.Black,
                    )
                },
                divider = {
                    HorizontalDivider(
                        color = colorResource(R.color.grey200),
                        thickness = 2.dp
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                title,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            when (selectedTabIndex) {
                0 -> FindId(
                    modifier = modifier,
                    callback = { id, email ->

                        coroutineScope.launch {
                            viewModel.getId(id, email)

                            if (viewModel.id.isNotEmpty()) {
                                dialogResult.apply {
                                    put("title", "아이디 찾기 결과")
                                    put("content", viewModel.id)
                                }

                                showDialog = true
                            }
                        }

                    }
                )

                1 -> if (viewModel.state != ViewModelState.ChangePW && viewModel.state != ViewModelState.Changing)

                    FindPw(
                        modifier = modifier,
                        callback = { id, phone, email ->
                            coroutineScope.launch {
                                viewModel.getPW(id, phone, email)

                                if (viewModel.password != 1000) {
                                    /// SHOW MESSAGE
                                    dialogResult.apply {
                                        put("title", "비밀번호 찾기 결과")
                                        put("content", "정보와 일치하는 계정을 찾지 못했습니다.")
                                    }

                                    showDialog = true
                                    return@launch
                                }
                            }
                        }
                    ) else ChangePw { password ->
                    coroutineScope.launch {
                        viewModel.changePW(
                            idx = 1,
                            pw = password
                        )

                        if (viewModel.changedPassword == true) {
                            dialogResult.apply {
                                put("title", "비밀번호 변경 결과")
                                put("content", "비밀번호가 정상적으로 변경되었습니다. 다시 로그인해주세요!")
                                put("buttonTitle", "로그인하기")
                                put("status", true)
                            }

                            showDialog = true
                            return@launch

                        } else {
                            dialogResult.apply {
                                put("title", "비밀번호 변경 결과")
                                put("content", "비밀번호 변경을 실패했습니다. 다시 시도해주세요!")
                                put("status", true)
                            }

                            showDialog = true
                            return@launch
                        }
                    }
                }

            }

            if (showDialog) {
                CustomDialog(
                    title = (dialogResult["title"] ?: "").toString(),
                    content = (dialogResult["content"] ?: "").toString(),
                    buttonTitle = (dialogResult["buttonTitle"] ?: "확인").toString(),
                    callback = {
                        showDialog = false

                        if (dialogResult["status"] != null){
                            Log.d("dialogResult[\"status\"]", " dialogResult[\"status\"] ${dialogResult["status"]}")
                        }
                        if ((dialogResult["status"] ?: false) as Boolean) {
                            navController.popBackStack()
                        }
                    }
                )
            }

        }
    }
}

@Composable
private fun FindId(
    modifier: Modifier = Modifier,
    callback: (String, String) -> Unit
) {

    val idState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        RoundedTextField(
            value = idState.value,
            onValueChange = { idState.value = it },
            hint = "전화번호 '-'없이 입력"
        )

        Spacer(modifier = modifier.height(13.dp))

        RoundedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            hint = "이메일 입력"
        )

        Spacer(modifier = Modifier.height(30.dp))

        DefaultBlackButton(
            modifier = modifier.padding(horizontal = 20.dp),
            title = "아이디 찾기",
            onClick = {
                callback(idState.value, emailState.value)
            }
        )
    }
}

@Composable
private fun FindPw(
    modifier: Modifier = Modifier,
    callback: (String, String, String) -> Unit
) {

    val idState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(horizontal = 20.dp)) {

        RoundedTextField(
            value = idState.value,
            onValueChange = { idState.value = it },
            hint = "아이디 입력"
        )

        Spacer(modifier = modifier.height(13.dp))

        RoundedTextField(
            value = phoneState.value,
            onValueChange = { phoneState.value = it },
            hint = "전화번호 '-'없이 입력"
        )

        Spacer(modifier = modifier.height(13.dp))

        RoundedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            hint = "이메일 입력"
        )

        Spacer(modifier = Modifier.height(30.dp))

        DefaultBlackButton(
            modifier = modifier.padding(horizontal = 20.dp),
            title = "비밀번호 변경",
            onClick = { callback(idState.value, phoneState.value, emailState.value) }
        )
    }
}


@Composable
private fun ChangePw(
    modifier: Modifier = Modifier,
    callback: (String) -> Unit
) {

    val pwState = remember { mutableStateOf("") }
    val pwConfirmState = remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = modifier.padding(horizontal = 20.dp)) {

        RoundedTextField(
            value = pwState.value,
            onValueChange = { pwState.value = it },
            hint = "새로운 비밀번호 입력"
        )

        Spacer(modifier = modifier.height(13.dp))

        RoundedTextField(
            value = pwConfirmState.value,
            onValueChange = { pwConfirmState.value = it },
            hint = "새로운 비밀번호 확인"
        )

        Spacer(modifier = Modifier.height(30.dp))

        DefaultBlackButton(
            modifier = modifier.padding(horizontal = 20.dp),
            title = "비밀번호 변경",
            onClick = {
                if (pwState.value != pwConfirmState.value) {
                    Toast.makeText(
                        context,
                        "비밀번호가 일치하지 않습니다.",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@DefaultBlackButton
                }

                callback(pwState.value)
            }
        )
    }
}