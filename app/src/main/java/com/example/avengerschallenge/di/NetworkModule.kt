package com.example.avengerschallenge.di

import com.example.avengerschallenge.BuildConfig
import com.example.avengerschallenge.data.AvengersAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesAvengersAPI(retrofit: Retrofit) : AvengersAPI =
        retrofit.create(AvengersAPI::class.java)
}