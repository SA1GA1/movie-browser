package com.example.movie_browser.ui.screens.movieDetails

import com.example.movie_browser.data.model.MovieDetails

sealed interface MovieDetailsState {
    object Loading: MovieDetailsState
    data class Success(val movie: MovieDetails): MovieDetailsState
    data class Error(val message: String): MovieDetailsState
}
