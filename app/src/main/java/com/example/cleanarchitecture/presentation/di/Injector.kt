package com.example.cleanarchitecture.presentation.di

import com.example.cleanarchitecture.presentation.di.movie.MovieSubComponent

interface Injector{
    fun creatMovieSubComonent(): MovieSubComponent
}