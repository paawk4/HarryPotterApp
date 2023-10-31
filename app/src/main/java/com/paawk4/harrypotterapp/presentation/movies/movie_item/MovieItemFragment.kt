package com.paawk4.harrypotterapp.presentation.movies.movie_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.paawk4.harrypotterapp.databinding.FragmentMovieItemBinding
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.presentation.movies.list_movies.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieItemFragment : Fragment() {

    private var _binding: FragmentMovieItemBinding? = null
    private val binding get() = _binding!!
    private val movieItemViewModel: MovieItemViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieItemBinding.inflate(inflater, container, false)
        observeViewModel()
        val movieId = arguments?.getString("movieId")
        if (movieId != null) {
            movieItemViewModel.requestMovie(movieId)
        } else {
            findNavController().popBackStack()
        }
        return binding.root
    }

    private fun observeViewModel() {
        movieItemViewModel.movieItem.observe(viewLifecycleOwner) {
            it.data?.let { item ->
                populateDataOnUi(item)
            }
        }
    }

    private fun populateDataOnUi(movie: Movie) {
        Glide.with(this)
            .load(movie.poster)
            .into(binding.sivPoster)
        with(binding) {
            tvTitle.text = movie.title
            tvDate.text = movie.releaseDate
            tvDirectors.text = "Directors: ${movie.directors}"
            tvRunningTime.text = movie.runningTime
            tvRating.text = movie.rating
            tvDescription.text = movie.summary.take(200)
            tvReadMore.setOnClickListener {
                tvDescription.text = movie.summary
            }
        }

    }

}