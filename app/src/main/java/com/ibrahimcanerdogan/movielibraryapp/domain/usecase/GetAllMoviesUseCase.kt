package com.ibrahimcanerdogan.movielibraryapp.domain.usecase

import com.ibrahimcanerdogan.movielibraryapp.data.remote.mapper.MovieMapper.toMovie
import com.ibrahimcanerdogan.movielibraryapp.domain.model.Movie
import com.ibrahimcanerdogan.movielibraryapp.domain.repository.MovieRepository
import com.ibrahimcanerdogan.movielibraryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun execute(searchText : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getAllMovies(searchText)
            if (movieList.movieResponse.equals("True")) {
                emit(Resource.Success(movieList.toMovie()))
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