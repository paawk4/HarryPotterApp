package com.paawk4.harrypotterapp.data.spells

import com.paawk4.harrypotterapp.data.Entities
import com.paawk4.harrypotterapp.data.retrofit.RetrofitService
import com.paawk4.harrypotterapp.domain.spells.SpellsRepository
import com.paawk4.harrypotterapp.domain.spells.models.Spells
import com.paawk4.harrypotterapp.domain.utils.Result

class SpellsRepositoryImpl(
    private val retrofitService: RetrofitService
) : SpellsRepository {

    override fun getAllSpells(): Result<Spells> {
        return retrofitService.getAllItems(Entities.SPELLS) as Result<Spells>
    }

}