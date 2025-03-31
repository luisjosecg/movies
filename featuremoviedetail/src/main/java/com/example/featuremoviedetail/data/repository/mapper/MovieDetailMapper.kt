package com.example.featuremoviedetail.data.repository.mapper

import com.example.featuremoviedetail.data.remote.dto.MovieDetailDTO
import com.example.featuremoviedetail.domain.model.MovieDetail

fun MovieDetailDTO.toDomain(): MovieDetail {
    return MovieDetail(
        title = this.title,
        posterPath = this.posterPath,
        genres = this.genres.map { it.name },
        overview = this.overview,
        releaseDate = this.releaseDate
    )
}