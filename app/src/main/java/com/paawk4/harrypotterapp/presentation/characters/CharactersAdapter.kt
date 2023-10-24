package com.paawk4.harrypotterapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.paawk4.harrypotterapp.databinding.ItemCharacterBinding
import com.paawk4.harrypotterapp.domain.characters.models.Character

class CharactersAdapter :
    ListAdapter<Character, CharactersAdapter.ViewHolder>(CharactersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.characterName.text = item.name
        Glide.with(holder.itemView)
            .load(item.image)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.characterImage)
    }

    inner class ViewHolder(binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        val characterName: TextView = binding.characterItemTitle
        val characterImage: ImageView = binding.characterItemImage
    }

}