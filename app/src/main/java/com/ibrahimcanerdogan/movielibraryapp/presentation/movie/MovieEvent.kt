package com.ibrahimcanerdogan.movielibraryapp.presentation.movie

sealed class MovieEvent {
    data class SearchEvent(val searchText : String) : MovieEvent()
}