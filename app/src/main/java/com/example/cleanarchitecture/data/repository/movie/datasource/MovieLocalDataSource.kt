package com.example.cleanarchitecture.data.repository.movie.datasource

import com.example.cleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}