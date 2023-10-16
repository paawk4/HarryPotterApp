package com.paawk4.harrypotterapp.domain.characters

import com.paawk4.harrypotterapp.domain.characters.models.Characters
import com.paawk4.harrypotterapp.domain.utils.Result

interface CharactersRepository {

    fun getAllCharacters(): Result<Characters>
}