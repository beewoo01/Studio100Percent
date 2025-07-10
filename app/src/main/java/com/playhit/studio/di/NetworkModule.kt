package com.playhit.studio.di

import com.playhit.studio.BuildConfig
import com.playhit.studio.data.source.remote.JamendoAPIClient
import com.playhit.studio.data.source.remote.JamendoAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                },
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true // 알 수 없는 필드 무시
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.jamendo.com/v3.0/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideJamendoApiService(retrofit: Retrofit): JamendoAPIService {
        return retrofit.create(JamendoAPIService::class.java)
    }

    @Provides
    @Named("jamendo_client_id")
    fun provideJamendoClientId(): String = BuildConfig.JAMENDO_CLIENT_ID

    @Provides
    @Singleton
    fun provideJamendoApiClient(jamendoApiService: JamendoAPIService): JamendoAPIClient {
        return JamendoAPIClient(jamendoApiService)
    }
}