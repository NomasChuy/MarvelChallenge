package com.example.avengerschallenge.domain.repository

import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.core.utils.Resource

interface AvengersRepository {
    suspend fun fetchAvengersComics() : Resource<List<MarvelDomain>>
}