package com.moviedb.moviedb.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moviedb.moviedb.screen.view.MovieDetailScreen
import com.moviedb.moviedb.screen.view.MovieListScreen
import com.moviedb.moviedb.screen.viewmodel.MovieViewModel

@Composable
fun AppNavHost(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            MovieListScreen(navController = navController, movieViewModel = movieViewModel)
        }
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            MovieDetailScreen(Id = id, movieViewModel = movieViewModel)
        }
    }
}
