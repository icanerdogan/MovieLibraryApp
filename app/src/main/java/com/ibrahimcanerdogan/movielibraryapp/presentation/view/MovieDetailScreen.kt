package com.ibrahimcanerdogan.movielibraryapp.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.ibrahimcanerdogan.movielibraryapp.presentation.movie.MovieViewModel
import com.ibrahimcanerdogan.movielibraryapp.presentation.movie.detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel()
) {

    val state = viewModel.stateDetail.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        state.stateMovieDetail.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(data = it?.movieDataPoster),
                    contentDescription = it?.movieDataTitle,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(CenterHorizontally)
                )
                Text(
                    text = it?.movieDataTitle ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White
                )
                Text(
                    text = it?.movieDataActors ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White)
                Text(
                    text = it?.movieDataCountry ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White)
                Text(
                    text = it?.movieDataDirector ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White)
                Text(
                    text = it?.movieDataImdbRating ?: "",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(14.dp),
                    color = Color.White)

            }
        }
    }

    if (!state.stateError.isNullOrEmpty()) {
        Text(text = state.stateError ?: "",
        color = MaterialTheme.colors.error,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
        )
    }

    if (state.stateIsLoading) {
        CircularProgressIndicator()
    }

}