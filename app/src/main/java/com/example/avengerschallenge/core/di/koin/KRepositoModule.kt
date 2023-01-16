package com.example.avengerschallenge.core.di.koin

import com.example.avengerschallenge.data.repository.KAvengersRepositoryImp
import com.example.avengerschallenge.domain.repository.AvengersRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val krepositoryModule = module {
    singleOf(::KAvengersRepositoryImp) {
        bind<AvengersRepository>()
    }
}