package com.paawk4.harrypotterapp.data.characters

import com.paawk4.harrypotterapp.data.Entities
import com.paawk4.harrypotterapp.data.retrofit.RetrofitService
import com.paawk4.harrypotterapp.domain.characters.CharactersRepository
import com.paawk4.harrypotterapp.domain.characters.models.Characters
import com.paawk4.harrypotterapp.domain.utils.Result

class CharactersRepositoryImpl(
    private val retrofitService: RetrofitService
) : CharactersRepository {

    override fun getAllCharacters(): Result<Characters> {
        return retrofitService.getAllItems(Entities.CHARACTERS) as Result<Characters>
    }
}