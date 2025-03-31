package com.example.featuremovielist.domain.repository

import com.example.commons.Result
import com.example.featuremovielist.domain.model.Movie

interface MovieRepository {

    suspend fun getMovies():  Result<List<Movie>>

}