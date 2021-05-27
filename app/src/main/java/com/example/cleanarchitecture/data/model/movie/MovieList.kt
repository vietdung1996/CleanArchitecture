package com.example.cleanarchitecture.data.model.movie

import com.example.cleanarchitecture.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)