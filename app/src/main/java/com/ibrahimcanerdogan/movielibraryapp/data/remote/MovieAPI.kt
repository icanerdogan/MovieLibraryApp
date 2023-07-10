package com.ibrahimcanerdogan.movielibraryapp.data.remote

import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDTO
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDataDTO
import com.ibrahimcanerdogan.movielibraryapp.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    // http://www.omdbapi.com/?apikey=7428e468&s=batman
    @GET(".")
    suspend fun getAllMovies(
        @Query("s") searchText : String,
        @Query("apikey") apiKey: String = Constant.API_KEY
    ) : MovieDTO

    // https://www.omdbapi.com/?apikey=7428e468&i=tt0372784
    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") movieImdbID : String,
        @Query("apikey") apiKey: String = Constant.API_KEY
    ) : MovieDataDTO
}