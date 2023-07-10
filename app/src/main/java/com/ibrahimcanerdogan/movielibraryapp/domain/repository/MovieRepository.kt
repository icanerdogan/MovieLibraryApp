package com.ibrahimcanerdogan.movielibraryapp.domain.repository

import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDTO
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDataDTO

interface MovieRepository {

    suspend fun getAllMovies(searchText : String) : MovieDTO

    suspend fun getMovieDetail(movieImdbId : String) : MovieDataDTO
}