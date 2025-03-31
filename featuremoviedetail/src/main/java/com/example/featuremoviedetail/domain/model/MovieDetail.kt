package com.example.featuremoviedetail.domain.model

data class MovieDetail(
    val title: String,
    val posterPath: String?,
    val genres: List<String>,
    val overview: String,
    val releaseDate: String
)