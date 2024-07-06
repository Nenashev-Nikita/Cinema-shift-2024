package com.example.cinema.feature.history.di

import androidx.lifecycle.ViewModel
import com.example.cinema.util.di.ViewModelFactory
import javax.inject.Inject

class HistoryComponentViewModel: ViewModel() {

	@Inject
	lateinit var viewModelFactory: ViewModelFactory
}