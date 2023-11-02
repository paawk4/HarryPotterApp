package com.paawk4.harrypotterapp.presentation.movies.movie_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.paawk4.harrypotterapp.databinding.FragmentMovieItemBinding
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.MainActivity
import com.paawk4.harrypotterapp.presentation.utils.ProgressDialogManager
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).bottomNavigationView.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).bottomNavigationView.visibility = View.VISIBLE
    }

    private fun observeViewModel() {
        movieItemViewModel.movieItem.observe(viewLifecycleOwner) {
            when(it.responseType) {
                Status.LOADING -> ProgressDialogManager.showProgressDialog(requireActivity())
                Status.ERROR -> { ProgressDialogManager.hideProgressDialog() }
                Status.SUCCESSFUL -> {
                    it.data?.let { item ->
                        populateDataOnUi(item)
                    }
                    ProgressDialogManager.hideProgressDialog()
                }
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
            tvDirectors.text = buildString {
                append("Directors: ")
                append(movie.directors)
            }
            tvRunningTime.text = movie.runningTime
            tvRating.text = movie.rating
            tvDescription.text = movie.summary.take(200)
            tvReadMore.setOnClickListener {
                tvDescription.text = movie.summary
            }
            tvOtherInfo.text = buildString {
                append("screen writers: ")
                append(movie.screenwriters)
                append("\nproducers: ")
                append(movie.producers)
                append("\ncinematographers: ")
                append(movie.cinematographers)
                append("\neditors: ")
                append(movie.editors)
                append("\ndistributors: ")
                append(movie.distributors)
                append("\nmusic composers: ")
                append(movie.musicComposers)
                append("\nbudget: ")
                append(movie.budget)
                append("\nbox office: ")
                append(movie.boxOffice)
            }
        }

    }

}