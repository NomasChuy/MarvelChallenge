package com.example.avengerschallenge.data.mappers

import com.example.avengerschallenge.data.models.Comics
import com.example.avengerschallenge.data.models.Results
import com.example.avengerschallenge.domain.models.MarvelDomain

fun Results.toDomainMarvel() : MarvelDomain {
    return MarvelDomain(
        comics = this.comics.items.map { it.name },
        series = this.series.items.map { it.name },
        detail = this.urls.firstOrNull { it.type == "detail" }?.url ?: "",
        image = "${addStoHttp(this.thumbnail.path)}.${this.thumbnail.extension}",
        name = this.name,
        description = this.description.take(100)
    )
}

fun addStoHttp(path: String): String {
    return path.replace("http:","https:")
}
