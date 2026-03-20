package com.example.movie_browser.data.api

import com.example.movie_browser.data.model.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//val client = OkHttpClient()
//
//val request = Request.Builder()
//    .url("https://api.themoviedb.org/3/movie/popular")
//    .get()
//    .addHeader("accept", "application/json")
//    .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI")
//    .build()
//
//val response = client.newCall(request).execute()

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "ru-RU",
        @Query("page") page: Int = 1,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMDk3ZWU0MmQxMjMwODUwM2E1MDE3ZGUxNTIwNTIzNyIsIm5iZiI6MTc3NDAxNzU0MC41NjcwMDAyLCJzdWIiOiI2OWJkNWMwNDAzNWFmYzI4NmI0NWY0YzYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8jOl5evjumgIRk8wr85-QNHs7pCPNoB4MwJrOKBAADI"
    ): MovieResponse

}