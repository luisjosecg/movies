package com.example.featuremoviedetail.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.featuremoviedetail.navigation.AppNavigation
import com.example.uisystem.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = intent.getIntExtra("movieId", 0)
        setContent {
            MoviesTheme {
                AppNavigation(movieId)
            }
        }
    }
}