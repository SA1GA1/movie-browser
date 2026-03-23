package com.example.movie_browser.ui.screens.home

import com.example.movie_browser.data.model.Movie

data class HomeState (
    val popularMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val upcomingMovies: List<Movie> = emptyList(),
    val searchQuery: String = "",
    val searchResult: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null

)