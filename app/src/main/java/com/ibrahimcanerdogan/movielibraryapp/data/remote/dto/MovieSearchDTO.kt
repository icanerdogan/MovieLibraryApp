package com.ibrahimcanerdogan.movielibraryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieSearchDTO(
    @SerializedName("Title")
    val movieSearchTitle: String,
    @SerializedName("Year")
    val movieSearchYear: String,
    @SerializedName("imdbID")
    val movieSearchImdbID: String,
    @SerializedName("Type")
    val movieSearchType: String,
    @SerializedName("Poster")
    val movieSearchPoster: String
)