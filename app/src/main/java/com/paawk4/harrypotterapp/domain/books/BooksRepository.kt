package com.paawk4.harrypotterapp.domain.books

import com.paawk4.harrypotterapp.domain.books.models.Books
import com.paawk4.harrypotterapp.domain.utils.Result

interface BooksRepository {

    fun getAllBooks(): Result<Books>
}