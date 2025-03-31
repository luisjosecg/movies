package com.example.featuremovielist.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.uisystem.ui.components.ErrorMessage
import com.example.uisystem.ui.components.LoadingIndicator
import com.example.featuremovielist.R
import com.example.featuremovielist.domain.model.Movie
import com.example.featuremovielist.presentation.viewmodel.MovieListViewModel
import com.example.featuremovielist.presentation.component.MovieItem
import com.example.uisystem.ui.theme.Dimensions


@Composable
fun PopularMoviesList(
    onNavigate: (Movie) -> Unit
) {
    val viewModel: MovieListViewModel = hiltViewModel()
    val movies = viewModel.movies.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimensions.paddingLarge)
    ) {
        when {
            isLoading -> {
                LoadingIndicator()
            }
            errorMessage != null -> {
                ErrorMessage(message = errorMessage)
            }
            movies.isNotEmpty() -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(Dimensions.paddingMedium)
                ) {

                    Text(
                        text = stringResource(R.string.movie_list_title),
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(bottom = Dimensions.paddingSmall)
                            .align(Alignment.CenterHorizontally)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(Dimensions.paddingSmall)
                    ) {
                        items(movies) { movie ->
                            MovieItem(movie) {
                                onNavigate(movie)
                            }
                            Spacer(modifier = Modifier.height(Dimensions.spacerHeight))
                        }

                        item {
                            Spacer(modifier = Modifier.height(Dimensions.bottomSpacerHeight))
                        }
                    }
                }
            }
            else -> {
                Text(
                    text = stringResource(R.string.no_movies_found),
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}