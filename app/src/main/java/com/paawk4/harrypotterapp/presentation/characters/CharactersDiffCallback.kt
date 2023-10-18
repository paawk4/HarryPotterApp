package com.paawk4.harrypotterapp.presentation.characters

import androidx.recyclerview.widget.DiffUtil
import com.paawk4.harrypotterapp.domain.characters.models.Character

class CharactersDiffCallback: DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}