package com.paawk4.harrypotterapp.presentation.movies

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

    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        moviesViewModel.moviesList.observe(viewLifecycleOwner) {
            if (it.data != null) {
                with(binding.moviesRecyclerView) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = MoviesAdapter(it.data!!)
                    addItemDecoration(
                        LinearItemDecorator(
                            0,
                            resources.getDimensionPixelSize(R.dimen.vertical_space_rv)
                        )
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}