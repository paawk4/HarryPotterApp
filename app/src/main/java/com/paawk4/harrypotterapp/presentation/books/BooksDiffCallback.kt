package com.paawk4.harrypotterapp.presentation.books

import androidx.recyclerview.widget.DiffUtil
import com.paawk4.harrypotterapp.domain.books.models.Book
import com.paawk4.harrypotterapp.domain.movies.models.Movie

class BooksDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.serial == newItem.serial
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}