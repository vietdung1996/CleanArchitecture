package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.data.model.movie.Artist
import com.example.cleanarchitecture.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository)  {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}