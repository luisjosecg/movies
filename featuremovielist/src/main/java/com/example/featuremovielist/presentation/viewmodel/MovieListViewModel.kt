package com.example.featuremovielist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuremovielist.data.repository.ApiResult
import com.example.featuremovielist.domain.model.Movie
import com.example.featuremovielist.domain.useCase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadMovieList()
    }

    private fun loadMovieList() {
        _isLoading.value = true
        viewModelScope.launch {
            val result = getMoviesUseCase()
            when (result) {
                is ApiResult.Success -> {
                    _movies.value = result.data
                    _errorMessage.value = null
                }
                is ApiResult.Error -> {
                    _movies.value = emptyList()
                    _errorMessage.value = result.message
                }
                ApiResult.Loading -> {
                    _isLoading.value = true
                }
            }
            _isLoading.value = false
        }
    }
}