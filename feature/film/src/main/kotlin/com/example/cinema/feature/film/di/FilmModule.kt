package com.example.cinema.feature.film.di

import androidx.lifecycle.ViewModel
import com.example.cinema.feature.film.presentation.FilmViewModel
import com.example.cinema.util.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FilmModule {

	@Binds
	@IntoMap
	@ViewModelKey(FilmViewModel::class)
	fun bindFilmViewModule(
		viewModel: FilmViewModel
	): ViewModel
}