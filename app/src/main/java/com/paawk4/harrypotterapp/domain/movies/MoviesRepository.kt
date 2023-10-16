package com.paawk4.harrypotterapp.domain.movies

import com.paawk4.harrypotterapp.domain.movies.models.Movies
import com.paawk4.harrypotterapp.domain.utils.Result

interface MoviesRepository {

    fun getAllMovies(): Result<Movies>
}