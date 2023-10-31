package com.paawk4.harrypotterapp.presentation.movies.movie_item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.movies.usecases.GetSpecificMovieUseCase
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Result
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieItemViewModel(
    private val getSpecificMovieUseCase: GetSpecificMovieUseCase
) : BaseViewModel() {

    private val _movieItem: MutableLiveData<Data<Movie>> = MutableLiveData()
    val movieItem: LiveData<Data<Movie>>
        get() {
            return _movieItem
        }

    fun requestMovie(movieId: String) = launch {
        _movieItem.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getSpecificMovieUseCase(movieId) }) {
            is Result.Success -> {
                _movieItem.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _movieItem.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}