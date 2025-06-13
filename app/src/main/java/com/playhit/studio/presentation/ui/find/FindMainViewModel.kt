package com.playhit.studio.presentation.ui.find

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playhit.studio.domain.usecase.FindAccountInfoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ViewModelState {
    Loading,
    Idle,
    ChangePW,
    Changing
}

@HiltViewModel
class FindMainViewModel @Inject constructor(
     private val usecase: FindAccountInfoUsecase
) : ViewModel() {

    var id by mutableStateOf("")
        private set

    var password by mutableIntStateOf(0)
        private set

    var changedPassword : Boolean? by mutableStateOf(null)
        private set

    var state by mutableStateOf(ViewModelState.Idle)
        private set

    fun getId(phone: String, email: String) {
        viewModelScope.launch {
            state = ViewModelState.Loading
            usecase.findID(phone, email).run {
                id = this@run
            }

            state = ViewModelState.Idle
        }
    }

    fun getPW(id: String, phone: String, email: String) {
        viewModelScope.launch {
            state = ViewModelState.Loading
            usecase.findPW(id = id, phone = phone, email = email).run {
                password = this@run
            }
            Log.d("FIND", "1111")
            if(password == 1000) {
                Log.d("FIND", "22222")

                state = ViewModelState.ChangePW
                return@launch
            }
            Log.d("FIND", "33333")
            state = ViewModelState.Idle

        }
    }

    fun changePW(idx: Int, pw: String) {
        viewModelScope.launch {
            state = ViewModelState.Changing
            usecase.changePW(idx = idx, password = pw).run {
                changedPassword = this == 1000
            }

            //state = ViewModelState.Idle

        }
    }
}