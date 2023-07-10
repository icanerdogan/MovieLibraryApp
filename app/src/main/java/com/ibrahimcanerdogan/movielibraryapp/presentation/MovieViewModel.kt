package com.ibrahimcanerdogan.movielibraryapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.movielibraryapp.domain.usecase.GetAllMoviesUseCase
import com.ibrahimcanerdogan.movielibraryapp.domain.usecase.GetMovieDetailUseCase
import com.ibrahimcanerdogan.movielibraryapp.util.Constant
import com.ibrahimcanerdogan.movielibraryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<MovieState>(MovieState())
    val state : State<MovieState>
        get() = _state

    private val _stateDetail = mutableStateOf<MovieState>(MovieState())
    val stateDetail : State<MovieState>
        get() = _stateDetail

    // Continuous search fixed.
    private var job : Job? = null

    init {
        getAllMovies(_state.value.stateSearch ?: "Batman")
        stateHandle.get<String>(Constant.IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getAllMovies(searchText : String) {
        job?.cancel()

        job = getAllMoviesUseCase.execute(searchText).onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = MovieState(stateMovieList = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MovieState(stateError = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = MovieState(stateIsLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMovieDetail(movieImdbId : String) {
        getMovieDetailUseCase.execute(movieImdbId).onEach {
            when(it) {
                is Resource.Success -> {
                    _stateDetail.value = MovieState(stateMovieDetail = it.data)
                }
                is Resource.Error -> {
                    _stateDetail.value = MovieState(stateError = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _stateDetail.value = MovieState(stateIsLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
    fun onEvent(movieEvent: MovieEvent) {
        when(movieEvent) {
            is MovieEvent.SearchEvent -> {
                getAllMovies(movieEvent.searchText)
            }
        }
    }
}