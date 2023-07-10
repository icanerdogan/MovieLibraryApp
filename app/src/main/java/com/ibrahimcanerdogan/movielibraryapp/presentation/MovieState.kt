package com.ibrahimcanerdogan.movielibraryapp.presentation

import com.ibrahimcanerdogan.movielibraryapp.domain.model.Movie
import com.ibrahimcanerdogan.movielibraryapp.domain.model.MovieData

data class MovieState(
    val stateIsLoading : Boolean = false,
    val stateMovieList : List<Movie> = emptyList(),
    val stateMovieDetail : MovieData? = null,
    val stateError : String? = null,
    val stateSearch : String? = null
)