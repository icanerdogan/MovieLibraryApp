package com.ibrahimcanerdogan.movielibraryapp.presentation

import com.ibrahimcanerdogan.movielibraryapp.domain.model.Movie

data class MovieState(
    val stateIsLoading : Boolean = false,
    val stateMovieList : List<Movie> = emptyList(),
    val stateError : String? = null,
    val stateSearch : String? = null
)