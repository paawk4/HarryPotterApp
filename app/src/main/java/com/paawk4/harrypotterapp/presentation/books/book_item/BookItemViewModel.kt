package com.paawk4.harrypotterapp.presentation.books.book_item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.harrypotterapp.domain.books.models.Book
import com.paawk4.harrypotterapp.domain.books.usecases.GetSpecificBookUseCase
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Result
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookItemViewModel(
    private val getSpecificBookUseCase: GetSpecificBookUseCase
) : BaseViewModel() {

    private val _bookItem: MutableLiveData<Data<Book>> = MutableLiveData()
    val bookItem: LiveData<Data<Book>>
        get() {
            return _bookItem
        }

    fun requestBook(bookId: String) = launch {
        _bookItem.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getSpecificBookUseCase(bookId) }) {
            is Result.Success -> {
                _bookItem.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _bookItem.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}