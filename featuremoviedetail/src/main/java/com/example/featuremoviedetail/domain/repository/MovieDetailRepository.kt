package com.example.featuremoviedetail.domain.repository

import com.example.featuremoviedetail.data.repository.ApiResult
import com.example.featuremoviedetail.domain.model.MovieDetail


interface MovieDetailRepository {

    suspend fun getMovieDetail(movieId: Int):  ApiResult<MovieDetail>

}