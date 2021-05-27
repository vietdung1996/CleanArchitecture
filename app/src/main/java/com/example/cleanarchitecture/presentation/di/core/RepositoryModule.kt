package com.example.cleanarchitecture.presentation.di.core

import com.example.cleanarchitecture.data.repository.movie.MovieRepositoryImpl
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanarchitecture.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieReponsitory(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }
}