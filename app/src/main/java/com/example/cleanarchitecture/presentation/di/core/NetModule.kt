package com.example.cleanarchitecture.presentation.di.core

import com.example.cleanarchitecture.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
    }

    @Singleton
    @Provides
    fun provideTMDBservices(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}