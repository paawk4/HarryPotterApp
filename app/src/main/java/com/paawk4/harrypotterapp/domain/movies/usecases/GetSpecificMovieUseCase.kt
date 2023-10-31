package com.paawk4.harrypotterapp.domain.movies.usecases

import com.paawk4.harrypotterapp.domain.movies.MoviesRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetSpecificMovieUseCase: KoinComponent {
    private val moviesRepository: MoviesRepository by inject()
    operator fun invoke(boardId: String) = moviesRepository.getSpecificMovie(boardId)
}