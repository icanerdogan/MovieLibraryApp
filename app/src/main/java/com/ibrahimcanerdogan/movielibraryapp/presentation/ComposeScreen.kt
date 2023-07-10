package com.ibrahimcanerdogan.movielibraryapp.presentation

sealed class ComposeScreen(val route : String) {
    object MovieScreen : ComposeScreen("movie_screen")
    object MovieDetailScreen : ComposeScreen("movie_detail_screen")
}
