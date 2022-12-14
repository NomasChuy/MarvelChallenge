package com.example.avengerschallenge.domain

import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.utils.Resource

interface AvengersRepository {
    suspend fun fetchAvengersComics() : Resource<List<MarvelDomain>>
}