package com.playhit.studio.di

import com.playhit.studio.data.source.local.AccountApiService
import com.playhit.studio.data.source.local.AccountClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountServiceModule {

    @Provides
    @Singleton
    fun provideAccountApiService(): AccountApiService = AccountApiService()

    @Provides
    @Singleton
    fun bindAccountClient(
        service: AccountApiService
    ): AccountClient = AccountClient(service)
}