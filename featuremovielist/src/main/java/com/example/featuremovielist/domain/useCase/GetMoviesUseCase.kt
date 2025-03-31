package com.example.featuremovielist.domain.useCase

import com.example.commons.Result
import com.example.featuremovielist.domain.model.Movie
import com.example.featuremovielist.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository : MovieRepository) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return repository.getMovies()
    }

}