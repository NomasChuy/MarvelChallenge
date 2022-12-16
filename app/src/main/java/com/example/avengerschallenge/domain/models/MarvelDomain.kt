package com.example.avengerschallenge.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelDomain(
    val comics: List<String>,
    val series: List<String>,
    val detail: String,
    val image : String,
    val name : String,
    val description : String
): Parcelable
