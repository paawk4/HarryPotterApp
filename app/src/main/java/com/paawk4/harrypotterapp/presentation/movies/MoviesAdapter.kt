package com.paawk4.harrypotterapp.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.paawk4.harrypotterapp.databinding.ItemMovieBinding
import com.paawk4.harrypotterapp.domain.movies.models.Movie

class MoviesAdapter() :
    ListAdapter<Movie, MoviesAdapter.ViewHolder>(MoviesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.movieTitle.text = item.title
        holder.movieDate.text = item.releaseDate
        holder.movieDescription.text = item.summary
        holder.moviePoster.load(item.poster)
    }

    inner class ViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        val movieTitle: TextView = binding.movieTitle
        val moviePoster: ImageView = binding.moviePoster
        val movieDate: TextView = binding.movieDate
        val movieDescription: TextView = binding.movieDescription
    }

}