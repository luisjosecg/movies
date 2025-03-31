package com.example.featuremovielist.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.featuremoviedetail.di.MovieDetailActivity
import com.example.featuremovielist.presentation.ui.PopularMoviesList

private const val HOME = "home"
private const val DETAIL = "details/{movieId}"

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            PopularMoviesList { movie ->
                navController.navigate("${DETAIL}/${movie.id}")
            }

        }
        composable("${DETAIL}/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toInt() ?: 0
            val context = LocalContext.current
            LaunchedEffect(Unit) {
                val intent = Intent(context, MovieDetailActivity::class.java).apply {
                    putExtra("movieId", movieId)
                }
                context.startActivity(intent)
                navController.popBackStack()
            }
        }
    }
}