package com.example.avengerschallenge.data

import com.example.avengerschallenge.data.models.Avengers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AvengersAPI {
    @GET("characters")
    suspend fun fetchAvengers() : Response<Avengers>
}