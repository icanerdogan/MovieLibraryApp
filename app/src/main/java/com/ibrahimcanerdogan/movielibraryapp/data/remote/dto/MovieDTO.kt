package com.ibrahimcanerdogan.movielibraryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("Search")
    val movieSearch: List<MovieSearchDTO>,
    @SerializedName("totalResults")
    val movieTotalResults: String,
    @SerializedName("Response")
    val movieResponse: String
)