package com.example.movie_browser.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movie_browser.ui.components.MovieSection


@Composable
fun HomeScreen(
    onMovieClick: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()

    Box (modifier = Modifier.fillMaxSize()) {
       if (screenState.isLoading) {
           CircularProgressIndicator(
               modifier = Modifier.align(Alignment.Center),
               color = MaterialTheme.colorScheme.primary
           )
       }
       else {
           LazyColumn {
               // item { HomeSearchBar()} допилить поиск

               // хайповые филмс
               item {
                   MovieSection(
                       title = "Популярное",
                       movies = screenState.popularMovies,
                       onMovieClick = onMovieClick
                   )
               }

               // legend films
               item {
                   MovieSection(
                       title = "Лучшие фильмы",
                       movies = screenState.topRatedMovies,
                       onMovieClick = onMovieClick
                   )
               }

               // ну типо скоро
               item {
                   MovieSection(
                       title = "Скоро в кино",
                       movies = screenState.upcomingMovies,
                       onMovieClick = onMovieClick
                   )
               }
           }
       }
    }
}