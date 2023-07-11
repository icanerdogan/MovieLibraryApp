package com.ibrahimcanerdogan.movielibraryapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahimcanerdogan.movielibraryapp.presentation.ComposeScreen
import com.ibrahimcanerdogan.movielibraryapp.presentation.movie.MovieEvent
import com.ibrahimcanerdogan.movielibraryapp.presentation.movie.MovieViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MovieViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                onSearch = {
                    viewModel.onEvent(MovieEvent.SearchEvent(it))
                })

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)) {
                items(state.stateMovieList) { movie ->
                    MovieItem(movie = movie, onItemClick = {
                        navController.navigate(ComposeScreen.MovieDetailScreen.route + "/{${movie.movieSearchImdbID}}")
                    })
                }
            }
        }
    }
}

