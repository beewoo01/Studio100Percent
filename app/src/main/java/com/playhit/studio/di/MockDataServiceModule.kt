package com.playhit.studio.di

import com.playhit.studio.data.source.local.MockDataApiService
import com.playhit.studio.data.source.local.MockDataClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MockDataServiceModule {

    @Provides
    @Singleton
    fun provideMockDataApiService() : MockDataApiService = MockDataApiService()

    @Provides
    @Singleton
    fun bindMockDataClient(service: MockDataApiService): MockDataClient = MockDataClient(service)


}