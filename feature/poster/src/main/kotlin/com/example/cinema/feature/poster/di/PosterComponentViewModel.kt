package com.example.cinema.feature.poster.di

import androidx.lifecycle.ViewModel
import com.example.cinema.util.di.ViewModelFactory
import javax.inject.Inject

class PosterComponentViewModel: ViewModel() {

	@Inject
	lateinit var viewModelFactory: ViewModelFactory
}