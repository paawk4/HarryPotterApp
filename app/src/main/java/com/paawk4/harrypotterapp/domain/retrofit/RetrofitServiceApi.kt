package com.paawk4.harrypotterapp.domain.retrofit

import com.paawk4.harrypotterapp.domain.books.models.Book
import com.paawk4.harrypotterapp.domain.books.models.Books
import com.paawk4.harrypotterapp.domain.characters.models.Character
import com.paawk4.harrypotterapp.domain.characters.models.Characters
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.movies.models.Movies
import com.paawk4.harrypotterapp.domain.spells.models.Spells
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceApi {

    @GET("books")
    fun getAllBooks(): Call<Books>

    @GET("characters")
    fun getAllCharacters(): Call<Characters>

    @GET("spells")
    fun getAllSpells(): Call<Spells>

    @GET("movies")
    fun getAllMovies(): Call<Movies>

    @GET("movies/{movieId}")
    fun getSpecificMovie(@Path("movieId") movieId: String): Call<Movie>

    @GET("character/{characterName}")
    fun getSpecificCharacter(@Path("characterName") characterName: String): Call<Character>

    @GET("books/{bookId}")
    fun getSpecificBook(@Path("bookId") bookId: String): Call<Book>

}