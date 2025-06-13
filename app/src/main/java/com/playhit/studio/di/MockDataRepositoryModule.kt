package com.playhit.studio.di

import com.playhit.studio.data.repository.MockDataRepositoryImpl
import com.playhit.studio.domain.repository.MockDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MockDataRepositoryModule {

    @Binds
    @Singleton
    fun bindMockDataRepository(repository: MockDataRepositoryImpl) : MockDataRepository


}