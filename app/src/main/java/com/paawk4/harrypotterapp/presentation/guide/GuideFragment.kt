package com.paawk4.harrypotterapp.presentation.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentGuideBinding
import com.paawk4.harrypotterapp.domain.guide.Guide

class GuideFragment : Fragment() {

    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding!!

    private val guideList = listOf(
        Guide(
            "Movies",
            R.drawable.guide_movies
        ),
        Guide(
            "Spells",
            R.drawable.guide_spells
        ),
        Guide(
            "Books",
            R.drawable.guide_books
        ),
        Guide(
            "Characters",
            R.drawable.guide_characters
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initGridView()
        return root
    }

    private fun initGridView() {
        val adapter = GuideAdapter(requireActivity(), guideList)
        binding.guideGridView.adapter = adapter
        val navController = findNavController()
        binding.guideGridView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                when (guideList[position].title) {
                    "Movies" -> navController.navigate(R.id.action_navigation_guide_to_movieFragment)
//                    "Spells" -> navController.navigate(R.id.action_navigation_guide_to_movieFragment)
                    "Books" -> navController.navigate(R.id.action_navigation_guide_to_bookFragment)
                    "Characters" -> navController.navigate(R.id.action_navigation_guide_to_charactersFragment)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}