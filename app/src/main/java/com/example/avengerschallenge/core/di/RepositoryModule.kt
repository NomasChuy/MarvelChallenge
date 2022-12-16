package com.example.avengerschallenge.core.di

import com.example.avengerschallenge.data.repository.AvengersRepositoryImpl
import com.example.avengerschallenge.domain.repository.AvengersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(impl : AvengersRepositoryImpl) : AvengersRepository
}