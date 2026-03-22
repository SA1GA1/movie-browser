package com.example.movie_browser.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_browser.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Log
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.update

class HomeViewModel (
    private val repository: MovieRepository = MovieRepository()
): ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadAllMovies()
    }

    private fun loadAllMovies() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null)}
            try {
                // одновременный запуск всех запросов
                val popularDeferred = async { repository.getPopularMovies() }
                val topRatedDeferred = async { repository.getTopRatedMovies() }
                val upcomingDeferred = async { repository.getUpcomingMovies() }

                // ожидание завершения запросов
                val popular = popularDeferred.await()
                val topRated = topRatedDeferred.await()
                val upcoming = upcomingDeferred.await()

                // обновление состояния для всех данных разом
                _state.update {
                    it.copy(
                        popularMovies = popular.results,
                        topRatedMovies = topRated.results,
                        upcomingMovies = upcoming.results,
                        isLoading = false
                    )
                }
            }
            catch (e: Exception) {
                Log.e("MOVIE_DEBUG", "Ошибка при загрузке данных", e)
                _state.update { it.copy(isLoading = false, errorMessage = e.message) }
            }
        }
    }
}