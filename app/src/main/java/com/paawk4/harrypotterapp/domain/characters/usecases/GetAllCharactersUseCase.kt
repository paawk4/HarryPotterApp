package com.paawk4.harrypotterapp.domain.characters.usecases

import com.paawk4.harrypotterapp.domain.characters.CharactersRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllCharactersUseCase : KoinComponent {
    private val charactersRepository: CharactersRepository by inject()
    operator fun invoke() = charactersRepository.getAllCharacters()
}