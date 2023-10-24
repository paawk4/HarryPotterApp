package com.paawk4.harrypotterapp.presentation.movies.list_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
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
        Glide.with(holder.itemView)
            .load(item.poster)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.moviePoster)
        holder.movieRunningTime.text = item.runningTime
    }

    inner class ViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        val movieTitle: TextView = binding.movieTitle
        val moviePoster: ImageView = binding.moviePoster
        val movieDate: TextView = binding.movieDate
        val movieDescription: TextView = binding.movieDescription
        val movieRunningTime: TextView = binding.movieRunningTime
    }

}