package com.paawk4.harrypotterapp.presentation.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.paawk4.harrypotterapp.databinding.FragmentBooksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!

    private val booksViewModel: BooksViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        booksViewModel.booksList.observe(viewLifecycleOwner) {
            if (it.data != null) {
                binding.booksRecyclerView.layoutManager = LinearLayoutManager(context)
                binding.booksRecyclerView.adapter = BooksAdapter(it.data!!)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
