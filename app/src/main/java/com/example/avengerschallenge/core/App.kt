package com.example.avengerschallenge.core

import android.app.Application
import com.example.avengerschallenge.core.di.koin.KnetworkModuleRetrofit
import com.example.avengerschallenge.core.di.koin.krepositoryModule
import com.example.avengerschallenge.core.di.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(krepositoryModule, KnetworkModuleRetrofit, viewModelModule)
        }
    }
}