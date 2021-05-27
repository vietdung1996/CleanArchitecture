package com.example.cleanarchitecture.data.model.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.model.tvshow.TvShow


@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}