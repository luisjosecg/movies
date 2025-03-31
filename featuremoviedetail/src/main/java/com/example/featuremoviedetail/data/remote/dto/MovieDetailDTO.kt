package com.example.featuremoviedetail.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDTO(
    val id: Int,
    val title: String,
    @SerializedName("poster_path") val posterPath: String?,
    val genres: List<Genre>,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String
)