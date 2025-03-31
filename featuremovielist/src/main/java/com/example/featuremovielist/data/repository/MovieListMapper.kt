package com.example.featuremovielist.data.repository

import com.example.featuremovielist.data.remote.dto.MovieDTO
import com.example.featuremovielist.domain.model.Movie

fun MovieDTO.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterPath = posterPath,
        genreIds = genreIds,
        overview = overview,
        releaseDate = releaseDate
    )
}