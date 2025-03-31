package com.example.featuremoviedetail.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.featuremoviedetail.presentation.ui.MovieDetailsScreen

private const val HOME = "home"

@Composable
fun AppNavigation(movieId: Int) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            MovieDetailsScreen(movieId)
        }
    }
}