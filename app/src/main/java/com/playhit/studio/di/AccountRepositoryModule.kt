package com.playhit.studio.di

import com.playhit.studio.data.repository.AccountRepositoryImpl
import com.playhit.studio.domain.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AccountRepositoryModule {

    @Binds
    @Singleton
    fun bindAccountRepository(repository: AccountRepositoryImpl): AccountRepository

}