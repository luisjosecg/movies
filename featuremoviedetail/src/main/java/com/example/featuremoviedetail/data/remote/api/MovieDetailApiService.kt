package com.example.featuremoviedetail.data.remote.api

import com.example.featuremoviedetail.data.remote.dto.MovieDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MovieDetailApiService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Header("Authorization") token: String = ApiConfig.AUTHORIZATION
    ): Response<MovieDetailDTO>
}