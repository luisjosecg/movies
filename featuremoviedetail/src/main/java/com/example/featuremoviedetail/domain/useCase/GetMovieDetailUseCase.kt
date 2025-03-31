package com.example.featuremoviedetail.domain.useCase

import com.example.featuremoviedetail.data.repository.ApiResult
import com.example.featuremoviedetail.domain.model.MovieDetail
import com.example.featuremoviedetail.domain.repository.MovieDetailRepository

class GetMovieDetailUseCase(private val repository : MovieDetailRepository) {

    suspend operator fun invoke(movieId: Int): ApiResult<MovieDetail> {
        return repository.getMovieDetail(movieId)
    }

}