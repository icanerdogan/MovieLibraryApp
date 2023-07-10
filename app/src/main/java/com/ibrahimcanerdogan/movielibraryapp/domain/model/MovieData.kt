package com.ibrahimcanerdogan.movielibraryapp.domain.model

import com.google.gson.annotations.SerializedName
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieRatingDTO

data class MovieData(
    @SerializedName("Title")
    val movieDataTitle: String,
    @SerializedName("Year")
    val movieDataYear: String,
    @SerializedName("Released")
    val movieDataReleased: String,
    @SerializedName("Runtime")
    val movieDataRuntime: String,
    @SerializedName("Genre")
    val movieDataGenre: String,
    @SerializedName("Director")
    val movieDataDirector: String,
    @SerializedName("Writer")
    val movieDataWriter: String,
    @SerializedName("Actors")
    val movieDataActors: String,
    @SerializedName("Plot")
    val movieDataPlot: String,
    @SerializedName("Language")
    val movieDataLanguage: String,
    @SerializedName("Country")
    val movieDataCountry: String,
    @SerializedName("Poster")
    val movieDataPoster: String,
    @SerializedName("Ratings")
    val movieDataRatings: List<MovieRatingDTO>,
    @SerializedName("imdbRating")
    val movieDataImdbRating: String,
    @SerializedName("BoxOffice")
    val movieDataBoxOffice: String,
)