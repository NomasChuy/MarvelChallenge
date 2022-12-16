package com.example.avengerschallenge.core.di

import com.example.avengerschallenge.BuildConfig
import com.example.avengerschallenge.data.api.AvengersAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient =
        OkHttpClient.Builder()
            /*.addInterceptor { chain ->
                val ts = Timestamp(System.currentTimeMillis()).time.toString()
                val input = "$ts${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}"
                val md = MessageDigest.getInstance("MD5")
                val hash = BigInteger(1, md.digest(input.toByteArray()))
                    .toString(16)
                    .padStart(32, '0')

                val request = chain.request()
                val url = request.url

                val newUrl = url.newBuilder().apply {
                    this.addQueryParameter("ts", ts)
                    this.addQueryParameter("hash", hash)
                    this.addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
                    this.addQueryParameter("limit","100")
                }.build()

                val newRequest = request.newBuilder().url(newUrl).build()

                chain.proceed(newRequest)
            }*/
            .addInterceptor( HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) )
            .build()

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