package com.paawk4.harrypotterapp.presentation.books.list_books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.harrypotterapp.domain.books.models.Book
import com.paawk4.harrypotterapp.domain.books.models.Books
import com.paawk4.harrypotterapp.domain.books.usecases.GetAllBooksUseCase
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Result
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BooksViewModel(private val getAllBooksUseCase: GetAllBooksUseCase) : BaseViewModel() {

    private var _booksList: MutableLiveData<Data<List<Book>>> = MutableLiveData()
    val booksList: LiveData<Data<List<Book>>>
        get() {
            return _booksList
        }

    init {
        requestMovies()
    }

    private fun requestMovies() = launch {
        _booksList.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getAllBooksUseCase() }) {
            is Result.Success -> {
                _booksList.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _booksList.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}