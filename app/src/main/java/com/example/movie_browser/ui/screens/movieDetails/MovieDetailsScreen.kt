package com.example.movie_browser.ui.screens.movieDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieDetailsScreen(
    movieId: Int
) {
    Text(text = "ID фильма $movieId")
}