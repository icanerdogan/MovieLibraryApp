package com.ibrahimcanerdogan.movielibraryapp.domain.usecase

import com.ibrahimcanerdogan.movielibraryapp.data.remote.mapper.MovieMapper.toMovieData
import com.ibrahimcanerdogan.movielibraryapp.domain.model.MovieData
import com.ibrahimcanerdogan.movielibraryapp.domain.repository.MovieRepository
import com.ibrahimcanerdogan.movielibraryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun execute(movieImdbID : String) : Flow<Resource<MovieData>> = flow {
        try {
            emit(Resource.Loading())
            val movieData = repository.getMovieDetail(movieImdbID)
            if (movieData.movieDataResponse == "True") {
                emit(Resource.Success(movieData.toMovieData()))
            } else {
                emit(Resource.Error("No Movie Found!"))
            }
        } catch (e: IOError) {
            emit(Resource.Error("No Internet Connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error!"))
        }
    }
}