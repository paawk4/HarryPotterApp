package com.paawk4.harrypotterapp.domain.books.usecases

import com.paawk4.harrypotterapp.domain.books.BooksRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllBooksUseCase : KoinComponent {
    private val booksRepository : BooksRepository by inject()
    operator fun invoke() = booksRepository.getAllBooks()
}