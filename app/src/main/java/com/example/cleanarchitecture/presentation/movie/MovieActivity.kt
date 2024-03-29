package com.example.cleanarchitecture.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.databinding.ActivityMovieBinding
import com.example.cleanarchitecture.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).creatMovieSubComonent().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView();
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        binding.movieRecyclerView.adapter = movieAdapter
        displayPopularMovies()

    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}