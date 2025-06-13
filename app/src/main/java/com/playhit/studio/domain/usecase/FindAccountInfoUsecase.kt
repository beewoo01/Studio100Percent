package com.playhit.studio.domain.usecase

import com.playhit.studio.domain.repository.AccountRepository
import javax.inject.Inject

class FindAccountInfoUsecase @Inject constructor(
    val repository: AccountRepository
) {
    suspend fun findID(
        phone: String,
        email: String
    ): String = repository.findID(phone = phone, email = email)


    suspend fun findPW(
        id: String,
        phone: String,
        email: String
    ): Int = repository.findPW(id = id, phone = phone, email = email)


    suspend fun changePW(
        idx: Int,
        password: String
    ): Int = repository.changePW(idx = idx, pw = password)


}