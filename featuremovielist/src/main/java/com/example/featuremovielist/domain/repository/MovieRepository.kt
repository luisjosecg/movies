package com.example.featuremovielist.domain.repository

import com.example.featuremovielist.data.repository.ApiResult
import com.example.featuremovielist.domain.model.Movie

interface MovieRepository {

    suspend fun getMovies():  ApiResult<List<Movie>>

}