package com.example.movie_browser.data.repository

import com.example.movie_browser.data.model.MovieResponse
import com.example.movie_browser.di.NetworkModule

class MovieRepository {
    private val apiService = NetworkModule.apiService

    suspend fun getPopularMovies(): MovieResponse {
        return apiService.getPopularMovies(token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI")
    }

    suspend fun getTopRatedMovies(): MovieResponse {
        return apiService.getTopRatedMovies(token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI")
    }

    suspend fun getUpcomingMovies(): MovieResponse {
        return apiService.getUpcomingMovies(token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI")
    }

    suspend fun searchMovies(query: String): MovieResponse {
        return NetworkModule.apiService.searchMovies(
            query = query,
            token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
        )
    }
}