package com.example.movie_browser.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_browser.data.model.Movie
import com.example.movie_browser.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Log

class HomeViewModel (
    private val repository: MovieRepository = MovieRepository()
): ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())

    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
                val response = repository.getPopularMovies()
                Log.d("MOVIE_DEBUG", "Успешно: получено ${response.results.size} фильмов")
                _movies.value = response.results
            } catch (e: Exception) {
                Log.e("MOVIE_DEBUG", "Ошибка загрузки: ${e.message}", e)
            }
        }
    }
}