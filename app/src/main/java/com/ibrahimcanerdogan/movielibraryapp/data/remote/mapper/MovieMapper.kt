package com.ibrahimcanerdogan.movielibraryapp.data.remote.mapper

import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDTO
import com.ibrahimcanerdogan.movielibraryapp.data.remote.dto.MovieDataDTO
import com.ibrahimcanerdogan.movielibraryapp.domain.model.Movie
import com.ibrahimcanerdogan.movielibraryapp.domain.model.MovieData

object MovieMapper {

    fun MovieDTO.toMovie() : List<Movie> {
        return movieSearch.map {
            Movie(it.movieSearchTitle, it.movieSearchYear, it.movieSearchImdbID, it.movieSearchPoster)
        }
    }

    fun MovieDataDTO.toMovieData() : MovieData {
        return MovieData(
            movieDataTitle,
            movieDataYear,
            movieDataReleased,
            movieDataRuntime,
            movieDataGenre,
            movieDataDirector,
            movieDataWriter,
            movieDataActors,
            movieDataPlot,
            movieDataLanguage,
            movieDataCountry,
            movieDataPoster,
            movieDataRatings,
            movieDataImdbRating,
            movieDataBoxOffice
        )
    }
}