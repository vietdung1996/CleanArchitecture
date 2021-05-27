package com.anushka.tmdbclient.data.model.artist


import com.example.cleanarchitecture.data.model.movie.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>

)