package com.paawk4.harrypotterapp.presentation.books.list_books

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.FragmentBooksBinding
import com.paawk4.harrypotterapp.domain.utils.Data
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.utils.LinearItemDecorator
import com.paawk4.harrypotterapp.presentation.utils.ProgressDialogManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!
    private lateinit var booksAdapter: BooksAdapter
    private val booksViewModel: BooksViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        setupRecyclerView()
        observeViewModel()
        return binding.root
    }

    private fun setupRecyclerView() {
        booksAdapter = BooksAdapter()
        with(binding.booksRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
            addItemDecoration(
                LinearItemDecorator(
                    0,
                    resources.getDimensionPixelSize(R.dimen.vertical_space_rv)
                )
            )
        }
        booksAdapter.onBookItemClickListener = {
            val bundle = Bundle()
            bundle.putString("bookId", it.serial)
            findNavController().navigate(R.id.action_booksFragment_to_bookItemFragment, bundle)
        }
    }

    private fun observeViewModel() {
        booksViewModel.booksList.observe(viewLifecycleOwner) {
            when(it.responseType) {
                Status.LOADING -> ProgressDialogManager.showProgressDialog(requireActivity())
                Status.ERROR -> { ProgressDialogManager.hideProgressDialog() }
                Status.SUCCESSFUL -> {
                    it.data?.let { list ->
                        booksAdapter.submitList(list)
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
