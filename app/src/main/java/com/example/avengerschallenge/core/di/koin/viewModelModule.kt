package com.example.avengerschallenge.core.di.koin

import com.example.avengerschallenge.presentation.viewmodel.DetailViewModel
import com.example.avengerschallenge.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::DetailViewModel)
    viewModelOf(::MainViewModel)
}