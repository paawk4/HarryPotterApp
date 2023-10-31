package com.paawk4.harrypotterapp.data.movies

import com.paawk4.harrypotterapp.SpecificEntities
import com.paawk4.harrypotterapp.data.Entities
import com.paawk4.harrypotterapp.data.retrofit.RetrofitService
import com.paawk4.harrypotterapp.domain.movies.MoviesRepository
import com.paawk4.harrypotterapp.domain.movies.models.Movie
import com.paawk4.harrypotterapp.domain.movies.models.Movies
import com.paawk4.harrypotterapp.domain.utils.Result

class MoviesRepositoryImpl(
    private val retrofitService: RetrofitService
) : MoviesRepository {

    override fun getAllMovies(): Result<Movies> {
        return retrofitService.getAllItems(Entities.MOVIES) as Result<Movies>
    }

    override fun getSpecificMovie(movieId: String): Result<Movie> {
        return retrofitService.getSpecificItem(movieId, SpecificEntities.MOVIES) as Result<Movie>
    }
}