package com.ibrahimcanerdogan.movielibraryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieRatingDTO(
    @SerializedName("Source")
    val movieRatingSource: String,
    @SerializedName("Value")
    val movieRatingValue: String
)