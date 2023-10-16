package com.paawk4.harrypotterapp.domain.movies.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val serial: String,
    val title: String,
    val summary: String,
    val directors: List<String>,
    val screenwriters: List<String>,
    val producers: List<String>,
    val cinematographers: List<String>,
    val editors: List<String>,
    val distributors: List<String>,
    @SerializedName("music_composers")
    val musicComposers: List<String>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("running_time")
    val runningTime: String,
    val budget: String,
    @SerializedName("box_office")
    val boxOffice: String,
    val rating: String,
    val trailer: String,
    val poster: String,
    val wiki: String
)