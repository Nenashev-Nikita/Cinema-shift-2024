package com.example.cinema.feature.film.di

import androidx.lifecycle.ViewModel
import com.example.cinema.util.di.ViewModelFactory
import javax.inject.Inject

class FilmComponentViewModule: ViewModel() {

	@Inject
	lateinit var viewModelFactory: ViewModelFactory
}