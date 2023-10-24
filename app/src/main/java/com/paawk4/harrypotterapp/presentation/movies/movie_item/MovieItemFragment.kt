package com.paawk4.harrypotterapp.presentation.movies.movie_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentMovieItemBinding

class MovieItemFragment : Fragment() {

    private var _binding: FragmentMovieItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieItemBinding.inflate(inflater, container, false)
        return binding.root
    }

}