package com.playhit.studio.domain.repository

interface AccountRepository {
    fun login(
        id: String,
        password: String
    ): Int

    fun join(
        id: String,
        password: String,
        email: String,
        birth: String,
        phone: String,
        gender: Boolean
    ): Int

    fun findID(
        phone: String,
        email: String
    ): String

    fun findPW(
        id: String,
        phone: String,
        email: String
    ): Int

    fun changePW(
        idx: Int,
        pw: String,
    ): Int
}