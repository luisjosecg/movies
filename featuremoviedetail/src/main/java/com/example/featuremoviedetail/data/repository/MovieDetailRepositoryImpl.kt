package com.example.featuremoviedetail.data.repository

import com.example.featuremoviedetail.data.remote.api.MovieDetailApiService
import com.example.featuremoviedetail.data.remote.dto.MovieDetailDTO
import com.example.featuremoviedetail.data.remote.mapper.toDomain
import com.example.featuremoviedetail.domain.model.MovieDetail
import com.example.featuremoviedetail.domain.repository.MovieDetailRepository
import retrofit2.HttpException
import java.io.IOException


private const val MOVIE_DETAIL_NULL = "Movie detail is null"
private const val UNKNOWN_ERROR = "Unknown error"
private const val HTTP_ERROR = "HTTP Error: %s"
private const val NETWORK_ERROR = "Network Error: %s"
private const val UNEXPECTED_ERROR = "Unexpected Error: %s"

class MovieDetailRepositoryImpl(
    private val api: MovieDetailApiService
) : MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: Int): ApiResult<MovieDetail> {
        return try {
            val response = api.getMovieDetail(movieId)
            if (response.isSuccessful) {
                val movieDetailDTO: MovieDetailDTO? = response.body()
                if (movieDetailDTO != null) {
                    val movieDetail = movieDetailDTO.toDomain()
                    ApiResult.Success(movieDetail)
                } else {
                    ApiResult.Error(message = MOVIE_DETAIL_NULL, code = response.code())
                }
            } else {
                val errorMsg = response.errorBody()?.string() ?: UNKNOWN_ERROR
                ApiResult.Error(message = errorMsg, code = response.code())
            }
        } catch (e: HttpException) {
            ApiResult.Error(message = HTTP_ERROR.format(e.message()), code = e.code())
        } catch (e: IOException) {
            ApiResult.Error(message = NETWORK_ERROR.format(e.message))
        } catch (e: Exception) {
            ApiResult.Error(message = UNEXPECTED_ERROR.format(e.localizedMessage ?: ""))
        }
    }
}