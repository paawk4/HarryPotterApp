package com.paawk4.harrypotterapp.di

import com.paawk4.harrypotterapp.data.books.BooksRepositoryImpl
import com.paawk4.harrypotterapp.data.characters.CharactersRepositoryImpl
import com.paawk4.harrypotterapp.data.movies.MoviesRepositoryImpl
import com.paawk4.harrypotterapp.data.retrofit.RetrofitService
import com.paawk4.harrypotterapp.data.spells.SpellsRepositoryImpl
import com.paawk4.harrypotterapp.domain.books.BooksRepository
import com.paawk4.harrypotterapp.domain.books.usecases.GetAllBooksUseCase
import com.paawk4.harrypotterapp.domain.characters.CharactersRepository
import com.paawk4.harrypotterapp.domain.characters.usecases.GetAllCharactersUseCase
import com.paawk4.harrypotterapp.domain.movies.MoviesRepository
import com.paawk4.harrypotterapp.domain.movies.usecases.GetAllMoviesUseCase
import com.paawk4.harrypotterapp.domain.spells.SpellsRepository
import com.paawk4.harrypotterapp.domain.spells.usecases.GetAllSpellsUseCase
import com.paawk4.harrypotterapp.presentation.books.BooksViewModel
import com.paawk4.harrypotterapp.presentation.characters.CharactersViewModel
import com.paawk4.harrypotterapp.presentation.home.HomeViewModel
import com.paawk4.harrypotterapp.presentation.movies.list_movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoriesModule = module {
    single { RetrofitService() }
    single<BooksRepository> { BooksRepositoryImpl(get()) }
    single<CharactersRepository> { CharactersRepositoryImpl(get()) }
    single<SpellsRepository> { SpellsRepositoryImpl(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
}

val viewModelsModule = module {
    viewModel { HomeViewModel() }
    viewModel { MoviesViewModel(get()) }
    viewModel { BooksViewModel(get()) }
    viewModel { CharactersViewModel(get()) }
}

val useCasesModule = module {
    single { GetAllBooksUseCase() }
    single { GetAllMoviesUseCase() }
    single { GetAllSpellsUseCase() }
    single { GetAllCharactersUseCase() }
}