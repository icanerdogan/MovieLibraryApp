package com.ibrahimcanerdogan.movielibraryapp.presentation.movie.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.movielibraryapp.domain.usecase.GetMovieDetailUseCase
import com.ibrahimcanerdogan.movielibraryapp.presentation.movie.MovieState
import com.ibrahimcanerdogan.movielibraryapp.util.Constant
import com.ibrahimcanerdogan.movielibraryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _stateDetail = mutableStateOf<MovieDetailState>(MovieDetailState())
    val stateDetail : State<MovieDetailState>
        get() = _stateDetail

    init {
        stateHandle.get<String>(Constant.IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(movieImdbId : String) {
        val movieID = movieImdbId.replace("{", "")
        val newMovieID = movieID.replace("}", "")

        getMovieDetailUseCase.execute(newMovieID).onEach {
            when(it) {
                is Resource.Success -> {
                    _stateDetail.value = MovieDetailState(stateMovieDetail = it.data)
                }
                is Resource.Error -> {
                    _stateDetail.value = MovieDetailState(stateError = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _stateDetail.value = MovieDetailState(stateIsLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}