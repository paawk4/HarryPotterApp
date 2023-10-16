package com.paawk4.harrypotterapp.domain.retrofit

import com.paawk4.harrypotterapp.domain.books.models.Books
import com.paawk4.harrypotterapp.domain.characters.models.Characters
import com.paawk4.harrypotterapp.domain.movies.models.Movies
import com.paawk4.harrypotterapp.domain.spells.models.Spells
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceApi {

    @GET("books")
    fun getAllBooks(): Call<Books>

    @GET("characters")
    fun getAllCharacters(): Call<Characters>

    @GET("spells")
    fun getAllSpells(): Call<Spells>

    @GET("movies")
    fun getAllMovies(): Call<Movies>
}