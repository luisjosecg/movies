package com.example.featuremoviedetail.di

import com.example.featuremoviedetail.data.remote.api.MovieDetailApiService
import com.example.featuremoviedetail.data.repository.MovieDetailRepositoryImpl
import com.example.featuremoviedetail.domain.repository.MovieDetailRepository
import com.example.featuremoviedetail.domain.useCase.GetMovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {

    @Provides
    @Singleton
    fun provideMovieDetailApi(retrofit: Retrofit): MovieDetailApiService =
        retrofit.create(MovieDetailApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieDetailRepository(api: MovieDetailApiService): MovieDetailRepository =
        MovieDetailRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(repository: MovieDetailRepository): GetMovieDetailUseCase =
        GetMovieDetailUseCase(repository)

}