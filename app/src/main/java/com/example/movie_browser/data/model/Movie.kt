package com.example.movie_browser.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val adult: Boolean,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("genre_ids") val genreIds: List<Int>,
    val id: Int,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("release_date") val releaseDate: String?,
    val title: String,
    val video: Boolean,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int
)

//      "adult": false,
//      "backdrop_path": "/6yeVcxFR0j08vlv2OlL6zbewm4D.jpg",
//      "genre_ids": [28, 878, 53],
//      "id": 1265609,
//      "original_language": "en",
//      "original_title": "War Machine",
//      "overview": "Во время последней изнурительной миссии на подготовке рейнджеров боевой инженер должен возглавить подразделение в схватке с гигантской потусторонней машиной-убийцей.",
//      "popularity": 377.835,
//      "poster_path": "/eB863opfwAn0kV6SSWkfVUEzs2n.jpg",
//      "release_date": "2026-02-12",
//      "title": "Военная машина",
//      "video": false,
//      "vote_average": 7.273,
//      "vote_count": 983