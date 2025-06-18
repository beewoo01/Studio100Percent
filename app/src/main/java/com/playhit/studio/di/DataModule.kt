package com.playhit.studio.di

import com.playhit.studio.data.repository.JamendoRepositoryImpl
import com.playhit.studio.domain.repository.JamendoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindPokemonInfoRepository(repository: JamendoRepositoryImpl): JamendoRepository

}