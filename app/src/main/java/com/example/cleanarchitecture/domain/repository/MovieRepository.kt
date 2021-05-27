package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>
    suspend fun updateMovies():List<Movie>
}