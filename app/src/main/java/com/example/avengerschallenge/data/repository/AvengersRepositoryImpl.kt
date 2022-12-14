package com.example.avengerschallenge.data.repository

import com.example.avengerschallenge.data.AvengersAPI
import com.example.avengerschallenge.data.mappers.toDomainMarvel
import com.example.avengerschallenge.domain.AvengersRepository
import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.utils.Resource
import javax.inject.Inject

class AvengersRepositoryImpl @Inject constructor(private val avengersAPI: AvengersAPI) :
    AvengersRepository{
    override suspend fun fetchAvengersComics(): Resource<List<MarvelDomain>> {
        return try {
            val response = avengersAPI.fetchAvengers("","","")
            if (response.isSuccessful){
                val body = response.body()
                val result = body?.avData?.results?.map {
                    it.toDomainMarvel()
                } ?: throw Exception("Error")
                Resource.Success(result)
            }else{
                Resource.Failure("Error")
            }
        }catch (ex:Exception){
            Resource.Failure("Error")
        }
    }
}