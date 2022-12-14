package com.example.avengerschallenge.presentation.detailfragment

import androidx.lifecycle.ViewModel
import com.example.avengerschallenge.domain.AvengersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val avengersRepository: AvengersRepository)
    : ViewModel() {
    // TODO: Implement the ViewModel
}