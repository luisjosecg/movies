package com.example.featuremoviedetail.domain.repository

import com.example.commons.Result
import com.example.featuremoviedetail.domain.model.MovieDetail


interface MovieDetailRepository {

    suspend fun getMovieDetail(movieId: Int):  Result<MovieDetail>

}