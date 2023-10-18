package com.paawk4.harrypotterapp.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.harrypotterapp.domain.characters.models.Character
import com.paawk4.harrypotterapp.domain.characters.models.Characters
import com.paawk4.harrypotterapp.domain.characters.usecases.GetAllCharactersUseCase
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Result
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.BaseViewModel
import com.paawk4.harrypotterapp.presentation.utils.Houses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(private val getAllCharactersUseCase: GetAllCharactersUseCase) :
    BaseViewModel() {

    private var _charactersList: MutableLiveData<Data<List<Character>>> = MutableLiveData()
    val charactersList: LiveData<Data<List<Character>>>
        get() {
            return _charactersList
        }

    init {
        requestMovies()
    }

    private fun requestMovies() = launch {
        _charactersList.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getAllCharactersUseCase() }) {
            is Result.Success -> {
                _charactersList.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _charactersList.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }

    fun filterListByHouse(house: Houses) {
        if (_charactersList.value?.responseType == Status.SUCCESSFUL) {
            val filteredList =
                _charactersList.value?.data?.filter { it.house.lowercase() == house.name.lowercase() }!!
            _charactersList.value =
                Data(responseType = Status.SUCCESSFUL, data = filteredList)
        }
    }
}