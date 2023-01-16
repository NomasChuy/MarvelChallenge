package com.example.avengerschallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.avengerschallenge.domain.repository.AvengersRepository
import com.example.avengerschallenge.domain.models.MarvelDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class DetailViewModel : ViewModel() {
    var viewTitle: String = ""
    lateinit var viewCharacter: MarvelDomain
    var viewDetailList: List<String> = emptyList()

    fun setValues(detailTitle: String, character: MarvelDomain) {
        viewTitle = detailTitle
        viewCharacter = character
        viewDetailList = if(detailTitle == "Series") character.series else character.comics
    }
}