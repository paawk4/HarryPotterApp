package com.paawk4.harrypotterapp.domain.spells

import com.paawk4.harrypotterapp.domain.spells.models.Spells
import com.paawk4.harrypotterapp.domain.utils.Result

interface SpellsRepository {

    fun getAllSpells(): Result<Spells>
}