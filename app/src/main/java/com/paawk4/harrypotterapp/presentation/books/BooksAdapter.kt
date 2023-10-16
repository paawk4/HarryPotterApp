package com.paawk4.harrypotterapp.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.paawk4.harrypotterapp.databinding.ItemBookBinding
import com.paawk4.harrypotterapp.domain.books.models.Book

class BooksAdapter(
    private val values: List<Book>
) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bookTitle.text = item.title
        holder.bookDate.text = item.releaseDate
        holder.bookDescription.text = item.summary
        holder.bookImage.load(item.cover)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        val bookTitle: TextView = binding.bookTitle
        val bookImage: ImageView = binding.bookImage
        val bookDate: TextView = binding.bookDate
        val bookDescription: TextView = binding.bookDescription
    }

}