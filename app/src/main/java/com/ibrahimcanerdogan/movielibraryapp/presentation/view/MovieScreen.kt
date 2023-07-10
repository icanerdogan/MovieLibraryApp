package com.ibrahimcanerdogan.movielibraryapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahimcanerdogan.movielibraryapp.presentation.MovieEvent
import com.ibrahimcanerdogan.movielibraryapp.presentation.MovieViewModel

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

                    })
                }
            }
        }
    }
}

