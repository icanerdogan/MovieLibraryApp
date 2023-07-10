package com.ibrahimcanerdogan.movielibraryapp.data.repository

import com.ibrahimcanerdogan.movielibraryapp.data.remote.MovieAPI
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDTO
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDataDTO
import com.ibrahimcanerdogan.movielibraryapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieAPI: MovieAPI
) : MovieRepository {

    override suspend fun getAllMovies(searchText: String): MovieDTO {
        return movieAPI.getAllMovies(searchText)
    }

    override suspend fun getMovieDetail(movieImdbId: String): MovieDataDTO {
        return movieAPI.getMovieDetail(movieImdbId)
    }
}