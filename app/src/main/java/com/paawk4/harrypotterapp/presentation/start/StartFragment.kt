package com.paawk4.harrypotterapp.presentation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentStartBinding
import com.paawk4.harrypotterapp.presentation.MainActivity

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_navigation_home)
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        (requireActivity() as MainActivity).bottomNavigationView.visibility = View.VISIBLE

    }

}