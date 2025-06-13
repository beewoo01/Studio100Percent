package com.playhit.studio.data.repository

import com.playhit.studio.data.source.local.AccountClient
import com.playhit.studio.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDataClient: AccountClient
) : AccountRepository {

    override fun login(id: String, password: String): Int = accountDataClient.login(id, password)

    override fun join(
        id: String,
        password: String,
        email: String,
        birth: String,
        phone: String,
        gender: Boolean
    ): Int = accountDataClient.join(id, password, email, birth, phone, gender)


    override fun findID(phone: String, email: String): String =
        accountDataClient.findID(phone, email)

    override fun findPW(id: String, phone: String, email: String): Int =
        accountDataClient.findPW(id, phone, email)

    override fun changePW(idx: Int, pw: String) : Int =
        accountDataClient.changePW(idx = idx, pw = pw)


}
