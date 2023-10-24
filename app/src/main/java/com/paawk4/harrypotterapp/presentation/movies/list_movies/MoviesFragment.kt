package com.paawk4.harrypotterapp.presentation.movies.list_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentMoviesBinding
import com.paawk4.harrypotterapp.presentation.utils.LinearItemDecorator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        setupRecyclerView()
        observeViewModel()
        return binding.root
    }

    private fun setupRecyclerView() {
        moviesAdapter = MoviesAdapter()
        with(binding.moviesRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = moviesAdapter
            addItemDecoration(
                LinearItemDecorator(
                    0,
                    resources.getDimensionPixelSize(R.dimen.vertical_space_rv)
                )
            )
        }
    }

    private fun observeViewModel() {
        moviesViewModel.moviesList.observe(viewLifecycleOwner) {
            it.data?.let { list ->
                moviesAdapter.submitList(list)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}