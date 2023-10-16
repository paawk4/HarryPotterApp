package com.paawk4.harrypotterapp.data.books

import com.paawk4.harrypotterapp.data.Entities
import com.paawk4.harrypotterapp.data.retrofit.RetrofitService
import com.paawk4.harrypotterapp.domain.books.BooksRepository
import com.paawk4.harrypotterapp.domain.books.models.Books
import com.paawk4.harrypotterapp.domain.utils.Result

class BooksRepositoryImpl(
    private val retrofitService: RetrofitService
) : BooksRepository {

    override fun getAllBooks(): Result<Books> {
        return retrofitService.getAllItems(Entities.BOOKS) as Result<Books>
    }
}