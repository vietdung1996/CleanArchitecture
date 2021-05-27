package com.example.cleanarchitecture.presentation

import android.app.Application
import com.example.cleanarchitecture.BuildConfig
import com.example.cleanarchitecture.presentation.di.Injector
import com.example.cleanarchitecture.presentation.di.core.*
import com.example.cleanarchitecture.presentation.di.movie.MovieSubComponent


class App : Application(),
    Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun creatMovieSubComonent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}