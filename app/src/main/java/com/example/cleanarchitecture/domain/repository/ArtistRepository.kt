package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.model.movie.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>
    suspend fun updateArtists():List<Artist>
}