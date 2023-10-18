package com.paawk4.harrypotterapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentCharactersBinding
import com.paawk4.harrypotterapp.presentation.utils.GridItemDecorator
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private val charactersViewModel: CharactersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        charactersViewModel.charactersList.observe(viewLifecycleOwner) {
            if (it.data != null) {
                with(binding.charactersRecyclerView) {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = CharactersAdapter(it.data!!)
                    addItemDecoration(
                        GridItemDecorator(
                            resources.getDimensionPixelSize(R.dimen.horizontal_space_rv_grid),
                            resources.getDimensionPixelSize(R.dimen.vertical_space_rv_grid),
                            2
                        )
                    )
                }
            }
        }
    }


}