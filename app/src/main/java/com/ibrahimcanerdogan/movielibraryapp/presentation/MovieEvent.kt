package com.ibrahimcanerdogan.movielibraryapp.presentation

sealed class MovieEvent {
    data class SearchEvent(val searchText : String) : MovieEvent()
}