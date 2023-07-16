package com.ibrahimcanerdogan.movielibraryapp.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ibrahimcanerdogan.movielibraryapp.domain.model.Movie

@Composable
fun MovieItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(10.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalArrangement = Arrangement.Center,
    ) {

        Column(
            modifier = Modifier.align(CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = movie.movieSearchPoster),
                contentDescription = movie.movieSearchTitle,
                modifier = Modifier.padding(16.dp)
                    .size(200.dp, 200.dp)
                    .clip(RectangleShape)
            )
            Text(
                text = movie.movieSearchTitle,
                style = MaterialTheme.typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Text(
                text = movie.movieSearchYear,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}