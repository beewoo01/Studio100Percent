package com.playhit.studio.data.source.local

class AccountApiService {

    fun login(
        id: String,
        password: String
    ): Int = 0

    fun join(
        id: String,
        password: String,
        email: String,
        birth: String,
        phone: String,
        gender: Boolean
    ): Int = 0

    fun findID(
        phone: String,
        email: String
    ): String = "sampleid"

    fun findPW(
        id: String,
        phone: String,
        email: String
    ): Int = 1000

    fun changePW(idx: Int, pw: String): Int = 1000
}