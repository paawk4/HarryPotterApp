package com.paawk4.harrypotterapp.presentation.movies.list_movies

import androidx.recyclerview.widget.DiffUtil
import com.paawk4.harrypotterapp.domain.movies.models.Movie

class MoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.serial == newItem.serial
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}