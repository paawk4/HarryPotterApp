package com.paawk4.harrypotterapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paawk4.harrypotterapp.domain.books.usecases.GetAllBooksUseCase
import com.paawk4.harrypotterapp.domain.characters.usecases.GetAllCharactersUseCase
import com.paawk4.harrypotterapp.domain.movies.usecases.GetAllMoviesUseCase
import com.paawk4.harrypotterapp.domain.spells.usecases.GetAllSpellsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

}