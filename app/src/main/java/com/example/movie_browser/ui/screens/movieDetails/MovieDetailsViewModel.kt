package com.example.movie_browser.ui.screens.movieDetails

import android.util.Log
import com.example.movie_browser.data.repository.MovieRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val repository: MovieRepository = MovieRepository()
    ): ViewModel() {
    private val _state = MutableStateFlow<MovieDetailsState>(MovieDetailsState.Loading)
    val state: StateFlow<MovieDetailsState> = _state.asStateFlow()

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _state.value = MovieDetailsState.Loading
            try {
                val movie = repository.getMovieDetails(movieId)
                _state.value = MovieDetailsState.Success(movie)
            }
            catch (e: Exception) {
                Log.e("MOVIE_DEBUG", "Ошибка при загрузке данных фильмf", e)
                _state.value = MovieDetailsState.Error("Ошибка при загрузке данных фильма")
            }
        }
    }
}