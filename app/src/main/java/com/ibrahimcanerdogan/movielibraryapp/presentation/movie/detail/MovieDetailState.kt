package com.ibrahimcanerdogan.movielibraryapp.presentation.movie.detail

import com.ibrahimcanerdogan.movielibraryapp.domain.model.MovieData

data class MovieDetailState(
    val stateIsLoading : Boolean = false,
    val stateMovieDetail : MovieData? = null,
    val stateError : String? = null,
)