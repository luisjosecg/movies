package com.example.featuremoviedetail.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.featuremoviedetail.R
import com.example.featuremoviedetail.presentation.viewmodel.MovieDetailViewModel
import com.example.uisystem.ui.components.DetailText
import com.example.uisystem.ui.components.ErrorMessage
import com.example.uisystem.ui.components.LoadingIndicator
import com.example.featuremoviedetail.presentation.utils.Utils.formatDate
import com.example.uisystem.ui.theme.Dimensions

@Composable
fun MovieDetailsScreen(movieId: Int, viewModel: MovieDetailViewModel = hiltViewModel()) {

    val movieState = viewModel.movie.collectAsState().value
    val loading = viewModel.loading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    LaunchedEffect(movieId) {
        viewModel.loadMovieById(movieId)
    }

    when {
        loading -> LoadingIndicator()

        errorMessage != null -> ErrorMessage(message = errorMessage)

        movieState != null -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(Dimensions.paddingMedium),
                verticalArrangement = Arrangement.spacedBy(Dimensions.paddingSmall)
            ) {
                Spacer(modifier = Modifier.height(Dimensions.paddingLarge))

                Text(
                    text = stringResource(R.string.movie_detail_title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = Dimensions.paddingMedium),
                    textAlign = TextAlign.Left
                )

                Text(
                    text = "${stringResource(R.string.movie_title_label)} ${movieState.title}",
                    style = MaterialTheme.typography.titleMedium
                )

                Image(
                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movieState.posterPath}"),
                    contentDescription = stringResource(R.string.movie_poster_description),
                    modifier = Modifier
                        .height(Dimensions.imageSize)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                DetailText(
                    label = stringResource(R.string.movie_genres_label),
                    value = movieState.genres.joinToString(", ")
                )
                DetailText(
                    label = stringResource(R.string.movie_synopsis_label),
                    value = movieState.overview
                )
                DetailText(
                    label = stringResource(R.string.movie_release_date_label),
                    value = formatDate(movieState.releaseDate)
                )
            }
        }

        else -> ErrorMessage(message = stringResource(R.string.movie_not_found))
    }
}








