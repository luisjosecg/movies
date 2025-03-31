package com.example.featuremovielist.di

import com.example.featuremovielist.data.remote.api.MovieListApiService
import com.example.featuremovielist.data.repository.MovieRepositoryImpl
import com.example.featuremovielist.domain.repository.MovieRepository
import com.example.featuremovielist.domain.useCase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieListModule {

    @Provides
    fun provideBaseUrl() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieListApiService =
        retrofit.create(MovieListApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieListApiService): MovieRepository =
        MovieRepositoryImpl(api)



}