package com.example.movie_browser.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movie_browser.data.model.Movie


@Composable
fun MovieItem(
    movie: Movie,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(130.dp)
            .padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { onClick() }
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath ?: ""}",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Рейтинг
            Surface(
                color = if (movie.voteAverage >= 7.0) Color(0xFF4CAF50) else Color.Gray,
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = String.format(java.util.Locale.US, "%.1f", movie.voteAverage),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }
        }

        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    val fakeMovie = Movie(
        adult = false,
        backdropPath = "",
        genreIds = listOf(1, 2, 3),
        id = 123,
        originalLanguage = "en",
        originalTitle = "Fake Movie Title",
        overview = "Description here",
        popularity = 10.0,
        posterPath = "/eB863opfwAn0kV6SSWkfVUEzs2n.jpg",
        releaseDate = "2024-01-01",
        title = "Военная машина",
        video = false,
        voteAverage = 7.5,
        voteCount = 100
    )

    MovieItem(movie = fakeMovie, onClick = {})
}
