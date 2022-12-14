package com.example.avengerschallenge.data.models


import com.google.gson.annotations.SerializedName

data class Avengers(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val avData: Data,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)