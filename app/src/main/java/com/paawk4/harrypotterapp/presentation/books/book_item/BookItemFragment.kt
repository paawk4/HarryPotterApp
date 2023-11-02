package com.paawk4.harrypotterapp.presentation.books.book_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.paawk4.harrypotterapp.databinding.FragmentBookItemBinding
import com.paawk4.harrypotterapp.domain.books.models.Book
import com.paawk4.harrypotterapp.domain.utils.Status
import com.paawk4.harrypotterapp.presentation.MainActivity
import com.paawk4.harrypotterapp.presentation.utils.ProgressDialogManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookItemFragment : Fragment() {

    private var _binding: FragmentBookItemBinding? = null
    private val binding get() = _binding!!
    private val bookItemViewModel: BookItemViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookItemBinding.inflate(inflater, container, false)
        observeViewModel()
        val bookId = arguments?.getString("bookId")
        if (bookId != null) {
            bookItemViewModel.requestBook(bookId)
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
        bookItemViewModel.bookItem.observe(viewLifecycleOwner) {
            when (it.responseType) {
                Status.LOADING -> ProgressDialogManager.showProgressDialog(requireActivity())
                Status.ERROR -> {
                    ProgressDialogManager.hideProgressDialog()
                }

                Status.SUCCESSFUL -> {
                    it.data?.let { item ->
                        populateDataOnUi(item)
                    }
                    ProgressDialogManager.hideProgressDialog()
                }
            }

        }
    }

    private fun populateDataOnUi(book: Book) {
        Glide.with(this)
            .load(book.cover)
            .into(binding.sivPoster)
        with(binding) {
            tvTitle.text = book.title
            tvAuthor.text = book.author
            tvReleaseDate.text = book.releaseDate
            tvPages.text = book.pages
            tvDescription.text = book.summary.take(200)
            tvReadMore.setOnClickListener {
                tvDescription.text = book.summary
            }
            tvOtherInfo.text = book.dedication
        }
    }

}