package com.example.featuremovielist.data.remote.api

import com.example.featuremovielist.data.remote.dto.MoviesResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListApiService {
    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = MovieListApiConfig.API_KEY,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): Response<MoviesResponseDTO>
}