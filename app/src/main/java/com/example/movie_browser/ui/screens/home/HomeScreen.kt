package com.example.movie_browser.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movie_browser.ui.components.HomeSearchBar
import com.example.movie_browser.ui.components.MovieSection
import com.example.movie_browser.ui.components.SearchMovieItem

@Composable
fun HomeScreen(
    onMovieClick: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val screenState by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
    ) {
        if (screenState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color(0xFFFF5C00)
            )
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    HomeSearchBar(
                        query = screenState.searchQuery,
                        onQueryChange = { viewModel.onSearchQueryChange(it) },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                if (screenState.searchQuery.isEmpty()) {
                    item {
                        MovieSection(
                            title = "Популярное",
                            movies = screenState.popularMovies,
                            onMovieClick = onMovieClick
                        )
                    }

                    item {
                        MovieSection(
                            title = "Лучшие фильмы",
                            movies = screenState.topRatedMovies,
                            onMovieClick = onMovieClick
                        )
                    }

                    item {
                        MovieSection(
                            title = "Скоро в кино",
                            movies = screenState.upcomingMovies,
                            onMovieClick = onMovieClick
                        )
                    }
                } else {
                    items(screenState.searchResult) { movie ->
                        SearchMovieItem(
                            movie = movie,
                            onClick = { onMovieClick(movie.id) }
                        )
                    }
                }
            }
        }
    }
}
