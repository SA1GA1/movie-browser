package com.example.movie_browser.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movie_browser.data.model.Movie

@Composable
fun SearchMovieItem(
    movie: Movie,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w200${movie.posterPath}",
            contentDescription = null,
            modifier = Modifier
                .width(60.dp)
                .height(90.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )

        // 2. Инфо
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = (movie.releaseDate ?: "").take(4),
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}