package com.example.avengerschallenge.data.models


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemXXX>,
    @SerializedName("returned")
    val returned: Int
)