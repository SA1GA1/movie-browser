package com.example.movie_browser.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movie_browser.ui.screens.home.HomeScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movie_browser.ui.screens.movieDetails.MovieDetailsScreen

@Composable
fun NavGraph (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Главный экран
        composable(Screen.Home.route) {
            HomeScreen(onMovieClick = { movieId ->
                navController.navigate(Screen.Details.createRoute(movieId))
            })
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            MovieDetailsScreen(
                movieId = movieId,
                onBackCLick = { navController.popBackStack() }
            )
        }
    }
}