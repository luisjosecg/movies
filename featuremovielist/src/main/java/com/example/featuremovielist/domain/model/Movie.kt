package com.example.featuremovielist.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String?,
    val genreIds: List<Int>,
    val overview: String,
    val releaseDate: String
)