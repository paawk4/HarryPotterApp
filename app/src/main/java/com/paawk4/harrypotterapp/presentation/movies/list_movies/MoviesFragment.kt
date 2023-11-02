package com.paawk4.harrypotterapp.presentation.movies.list_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentMoviesBinding
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.LinearItemDecorator
import com.paawk4.harrypotterapp.presentation.utils.ProgressDialogManager
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
        moviesAdapter.onMovieItemClickListener = {
            val bundle = Bundle()
            bundle.putString("movieId", it.serial)
            findNavController().navigate(R.id.action_moviesFragment_to_movieItemFragment, bundle)
        }
    }

    private fun observeViewModel() {
        moviesViewModel.moviesList.observe(viewLifecycleOwner) {
            when(it.responseType) {
                Status.LOADING -> ProgressDialogManager.showProgressDialog(requireActivity())
                Status.ERROR -> { ProgressDialogManager.hideProgressDialog() }
                Status.SUCCESSFUL -> {
                    it.data?.let { list ->
                        moviesAdapter.submitList(list)
                    }
                    ProgressDialogManager.hideProgressDialog()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}