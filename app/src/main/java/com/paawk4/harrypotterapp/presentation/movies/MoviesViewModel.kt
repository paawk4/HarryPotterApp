package com.paawk4.harrypotterapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.harrypotterapp.domain.characters.models.Character
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.movies.models.Movies
import com.paawk4.harrypotterapp.domain.movies.usecases.GetAllMoviesUseCase
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Result
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(private val getAllMoviesUseCase: GetAllMoviesUseCase) : BaseViewModel() {

    private var _moviesList: MutableLiveData<Data<List<Movie>>> = MutableLiveData()
    val moviesList: LiveData<Data<List<Movie>>>
        get() {
            return _moviesList
        }

    init {
        requestMovies()
    }

    private fun requestMovies() = launch {
        _moviesList.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getAllMoviesUseCase() }) {
            is Result.Success -> {
                _moviesList.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _moviesList.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}