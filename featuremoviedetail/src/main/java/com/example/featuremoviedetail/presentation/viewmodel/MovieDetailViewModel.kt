package com.example.featuremoviedetail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commons.Result
import com.example.featuremoviedetail.domain.model.MovieDetail
import com.example.featuremoviedetail.domain.useCase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMoviesUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _movie = MutableStateFlow<MovieDetail?>(null)
    val movie: StateFlow<MovieDetail?> = _movie

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun loadMovieById(movieId: Int) {
        viewModelScope.launch {
            val result = getMoviesUseCase(movieId)
            when (result) {
                is Result.Success -> {
                    _movie.value = result.data
                    _errorMessage.value = null
                }
                is Result.Error -> {
                    _errorMessage.value = result.message
                    _movie.value = null
                }
            }
            _loading.value = false
        }
    }
}