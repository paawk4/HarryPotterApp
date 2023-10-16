package com.paawk4.harrypotterapp.domain.spells.usecases

import com.paawk4.harrypotterapp.domain.spells.SpellsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllSpellsUseCase : KoinComponent {
    private val spellsRepository: SpellsRepository by inject()
    operator fun invoke() = spellsRepository.getAllSpells()
}