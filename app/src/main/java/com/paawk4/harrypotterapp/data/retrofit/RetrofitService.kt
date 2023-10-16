package com.paawk4.harrypotterapp.data.retrofit

import com.paawk4.harrypotterapp.data.Entities
import com.paawk4.harrypotterapp.domain.utils.Result

class RetrofitService {
    private val api = RetrofitInstance.create()

    fun getAllItems(items: Entities): Result<Any> {
        val callResponse = when (items) {
            Entities.BOOKS -> api.getAllBooks()
            Entities.SPELLS -> api.getAllSpells()
            Entities.CHARACTERS -> api.getAllCharacters()
            Entities.MOVIES -> api.getAllMovies()
        }
        try {
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                }
            }
            return Result.Failure(Exception(response.message()))
        } catch (_: Exception) {
            return Result.Failure(Exception("no internet connection"))
        }
    }

}