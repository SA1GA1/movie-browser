package com.example.movie_browser.data.api

import com.example.movie_browser.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = "ru-RU",
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
    ): MovieResponse
}