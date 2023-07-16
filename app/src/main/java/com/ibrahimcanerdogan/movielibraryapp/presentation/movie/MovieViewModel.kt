package com.ibrahimcanerdogan.movielibraryapp.presentation.movie

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
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _splashIsLoading = MutableStateFlow(true)
    val splashIsLoading = _splashIsLoading.asStateFlow()

    private val _state = mutableStateOf<MovieState>(MovieState())
    val state : State<MovieState>
        get() = _state

    // Continuous search fixed.
    private var job : Job? = null

    init {
        getAllMovies(_state.value.stateSearch ?: "Red")
    }

    private fun getAllMovies(searchText : String) {
        job?.cancel()

        job = getAllMoviesUseCase.execute(searchText).onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = MovieState(stateMovieList = it.data ?: emptyList())
                    _splashIsLoading.value = false
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

    fun onEvent(movieEvent: MovieEvent) {
        when(movieEvent) {
            is MovieEvent.SearchEvent -> {
                getAllMovies(movieEvent.searchText)
            }
        }
    }
}