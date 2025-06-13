package com.playhit.studio.data.source.local

import javax.inject.Inject

class AccountClient @Inject constructor(
    private val accountApiService: AccountApiService
) {

    fun login(
        id: String,
        password: String
    ): Int = accountApiService.login(id, password)

    fun join(
        id: String,
        password: String,
        email: String,
        birth: String,
        phone: String,
        gender: Boolean
    ): Int = accountApiService.join(id, password, email, birth, phone, gender)

    fun findID(
        phone: String,
        email: String
    ): String = accountApiService.findID(phone, email)

    fun findPW(
        id: String,
        phone: String,
        email: String
    ): Int = accountApiService.findPW(id, phone, email)

    fun changePW(idx: Int, pw: String): Int = accountApiService.changePW(idx, pw)

}