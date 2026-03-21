package com.example.movie_browser.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movie_browser.ui.components.MovieItem


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val movies by viewModel.movies.collectAsStateWithLifecycle()

    if (movies.isEmpty()) {
        Text("Загрузка списка...")
    }
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    }
}