package com.example.movie_browser.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val movies by viewModel.movies.collectAsStateWithLifecycle()

    if (movies.isEmpty()) {
        Text("Загрузка списка...")
    }
    else {
        LazyColumn {
            items(movies) { movie ->
                Text(text = movie.title)
            }
        }
    }
}