package com.example.movie_browser.ui.screens.movieDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.movie_browser.data.model.MovieDetails
import androidx.compose.runtime.getValue

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    viewModel: MovieDetailsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()// загрузка при первом запуске
    LaunchedEffect(movieId) {
        viewModel.loadMovieDetails(movieId)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (val currentState = state) {
            is MovieDetailsState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is MovieDetailsState.Error -> {
                Text(
                    text = currentState.message,
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
            }
            is MovieDetailsState.Success -> {
                DetailsContent(movie = currentState.movie)
            }
        }
    }
}

@Composable
fun DetailsContent(movie: MovieDetails) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {


        Column(modifier = Modifier.padding(16.dp)) {
            //Название и слоган
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            movie.tagline?.let {
                Text(
                    text = "\"$it\"",
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

        //Баннер
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original${movie.backdropPath}",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

            Spacer(modifier = Modifier.height(16.dp))

            // Год длительность рейтинг
            Row(verticalAlignment = Alignment.CenterVertically) {
                InfoChip(text = (movie.releaseDate ?: "").take(4))
                Spacer(modifier = Modifier.width(8.dp))
                InfoChip(text = "${movie.runtime} мин")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Оценка: ${String.format("%.1f", movie.voteAverage)}",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Жанры
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(movie.genres) { genre ->
                    SuggestionChip(
                        onClick = { },
                        label = { Text(genre.name) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Описание",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = movie.overview ?: " ----- ",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun InfoChip(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}