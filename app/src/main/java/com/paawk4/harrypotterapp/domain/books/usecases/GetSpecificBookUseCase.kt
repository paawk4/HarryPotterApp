package com.paawk4.harrypotterapp.domain.books.usecases

import com.paawk4.harrypotterapp.domain.books.BooksRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetSpecificBookUseCase : KoinComponent {
    private val bookRepository: BooksRepository by inject()
    operator fun invoke(boardId: String) = bookRepository.getSpecificBook(boardId)
}