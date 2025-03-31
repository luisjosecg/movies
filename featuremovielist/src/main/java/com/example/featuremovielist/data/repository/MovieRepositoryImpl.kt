package com.example.featuremovielist.data.repository

import com.example.featuremovielist.data.remote.api.MovieListApiService
import com.example.featuremovielist.data.remote.mapper.toDomain
import com.example.featuremovielist.domain.model.Movie
import com.example.featuremovielist.domain.repository.MovieRepository
import retrofit2.HttpException
import java.io.IOException
import kotlin.text.format

private const val ERROR_HTTP = "HTTP error: %s"
private const val ERROR_NETWORK = "Network issue: %s"
private const val ERROR_UNKNOWN = "Unknown error"
private const val ERROR_UNEXPECTED = "Unexpected error: %s"

class MovieRepositoryImpl(
    private val api: MovieListApiService
) : MovieRepository {

    override suspend fun getMovies(): ApiResult<List<Movie>> {
        return try {
            val response = api.getPopularMovies()
            if (response.isSuccessful) {
                val movies = response.body()?.results?.map { it.toDomain() } ?: emptyList()
                ApiResult.Success(movies)
            } else {
                val errorMsg = response.errorBody()?.string() ?: ERROR_UNKNOWN
                ApiResult.Error(message = errorMsg, code = response.code())
            }
        } catch (e: HttpException) {
            ApiResult.Error(message = ERROR_HTTP.format(e.message()), code = e.code())
        } catch (e: IOException) {
            ApiResult.Error(message = ERROR_NETWORK.format(e.message))
        } catch (e: Exception) {
            ApiResult.Error(message = ERROR_UNEXPECTED.format(e.localizedMessage ?: ""))
        }
    }

}