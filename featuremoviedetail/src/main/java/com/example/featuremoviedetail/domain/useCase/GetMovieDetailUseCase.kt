package com.example.featuremoviedetail.domain.useCase

import com.example.commons.Result
import com.example.featuremoviedetail.domain.model.MovieDetail
import com.example.featuremoviedetail.domain.repository.MovieDetailRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository : MovieDetailRepository) {

    suspend operator fun invoke(movieId: Int): Result<MovieDetail> {
        return repository.getMovieDetail(movieId)
    }

}