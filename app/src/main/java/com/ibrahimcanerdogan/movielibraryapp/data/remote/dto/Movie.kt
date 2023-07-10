package com.ibrahimcanerdogan.movielibraryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Search")
    val movieSearch: List<MovieSearch>,
    @SerializedName("totalResults")
    val movieTotalResults: String,
    @SerializedName("Response")
    val movieResponse: String
)