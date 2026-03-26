package com.example.movie_browser.ui.screens.movieDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.sp
import java.util.Locale

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
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        // градиент + фон
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(440.dp)) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w780${movie.backdropPath}",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // плавное затемнение
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 100f
                    )
                ))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(320.dp)) // картинка

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = movie.releaseDate?.take(4) ?: "", color = Color.Gray)
                    Spacer(modifier = Modifier.width(12.dp))
                    Surface(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "${movie.runtime} мин",
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Оценка: ${String.format(Locale.US, "%.1f", movie.voteAverage)}", color = Color(0xFFFFD700))
                }

                if (!movie.tagline.isNullOrEmpty()) {
                    Text(
                        text = movie.tagline,
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                        color = Color.LightGray.copy(alpha = 0.7f)
                    )
                }

                Text(
                    text = movie.overview ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.padding(vertical = 16.dp),
                    lineHeight = 24.sp
                )

                // Жанры
                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    movie.genres.forEach { genre ->
                        Text(
                            text = genre.name,
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(0xFFFF5C00),
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
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