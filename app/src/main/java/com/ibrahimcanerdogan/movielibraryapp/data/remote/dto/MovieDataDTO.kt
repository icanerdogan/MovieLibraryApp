package com.ibrahimcanerdogan.movielibraryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDataDTO(
    @SerializedName("Title")
    val movieDataTitle: String,
    @SerializedName("Year")
    val movieDataYear: String,
    @SerializedName("Rated")
    val movieDataRated: String,
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
    @SerializedName("Awards")
    val movieDataAwards: String,
    @SerializedName("Poster")
    val movieDataPoster: String,
    @SerializedName("Ratings")
    val movieDataRatings: List<MovieRatingDTO>,
    @SerializedName("Metascore")
    val movieDataMetascore: String,
    @SerializedName("imdbRating")
    val movieDataImdbRating: String,
    @SerializedName("imdbVotes")
    val movieDataImdbVotes: String,
    @SerializedName("imdbID")
    val movieDataImdbID: String,
    @SerializedName("Type")
    val movieDataType: String,
    @SerializedName("DVD")
    val movieDataDVD: String,
    @SerializedName("BoxOffice")
    val movieDataBoxOffice: String,
    @SerializedName("Production")
    val movieDataProduction: String,
    @SerializedName("Website")
    val movieDataWebsite: String,
    @SerializedName("Response")
    val movieDataResponse: String
)