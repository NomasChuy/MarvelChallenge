package com.example.avengerschallenge.core.utils

sealed class Resource<T>{
    data class Success<T>(val data : T) : Resource<T>()
    data class Failure<T>(val message : String) : Resource<T>()
}
