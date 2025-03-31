package com.example.featuremovielist.domain.useCase

import com.example.featuremovielist.data.repository.ApiResult
import com.example.featuremovielist.domain.model.Movie
import com.example.featuremovielist.domain.repository.MovieRepository

class GetMoviesUseCase(private val repository : MovieRepository) {

    suspend operator fun invoke(): ApiResult<List<Movie>> {
        return repository.getMovies()
    }

}