package com.example.avengerschallenge.core.di.koin

import com.example.avengerschallenge.data.api.AvengersAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

val KnetworkModuleRetrofit = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideServiceRetrofit(get()) }

}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val ts = Timestamp(System.currentTimeMillis()).time.toString()
            val input = "$ts${com.example.avengerschallenge.BuildConfig.PRIVATE_KEY}${com.example.avengerschallenge.BuildConfig.PUBLIC_KEY}"
            val md = MessageDigest.getInstance("MD5")
            val hash = BigInteger(1, md.digest(input.toByteArray()))
                .toString(16)
                .padStart(32, '0')

            val request = chain.request()
            val url = request.url

            val newUrl = url.newBuilder().apply {
                this.addQueryParameter("ts", ts)
                this.addQueryParameter("hash", hash)
                this.addQueryParameter("apikey", com.example.avengerschallenge.BuildConfig.PUBLIC_KEY)
                this.addQueryParameter("limit","100")
            }.build()

            val newRequest = request.newBuilder().url(newUrl).build()

            chain.proceed(newRequest)
        }
        .addInterceptor(HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(com.example.avengerschallenge.BuildConfig.API_URL)
        .client(okHttpClient).addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideServiceRetrofit(retrofit: Retrofit): AvengersAPI {
    return retrofit.create(AvengersAPI::class.java)
}