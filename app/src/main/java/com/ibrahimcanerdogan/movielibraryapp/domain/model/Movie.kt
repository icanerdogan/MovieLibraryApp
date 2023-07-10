package com.ibrahimcanerdogan.movielibraryapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title")
    val movieSearchTitle: String,
    @SerializedName("Year")
    val movieSearchYear: String,
    @SerializedName("imdbID")
    val movieSearchImdbID: String,
    @SerializedName("Poster")
    val movieSearchPoster: String
)