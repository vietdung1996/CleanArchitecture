package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository{
    suspend fun getTvShows():List<TvShow>
    suspend fun updateTvShows():List<TvShow>
}