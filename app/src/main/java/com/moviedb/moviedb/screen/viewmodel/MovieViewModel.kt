package com.moviedb.moviedb.screen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviedb.moviedb.app.movieApiKEY
import com.moviedb.moviedb.model.Movie
import com.moviedb.moviedb.services.RetrofitInstance
import kotlinx.coroutines.launch


class MovieViewModel : ViewModel() {
    private val _movies = mutableStateOf<List<Movie>>(emptyList())
    val movies: State<List<Movie>> = _movies


    init {
        
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try {

                _movies.value = RetrofitInstance.apiService.getMovies(movieApiKEY)
            } catch (e: Exception) {
               print(e.message)
            }
        }
    }


}