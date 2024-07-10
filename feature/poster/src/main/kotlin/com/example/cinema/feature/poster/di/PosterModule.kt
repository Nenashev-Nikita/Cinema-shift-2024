package com.example.cinema.feature.poster.di

import androidx.lifecycle.ViewModel
import com.example.cinema.feature.poster.presentation.PosterViewModel
import com.example.cinema.util.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PosterModule {

	@Binds
	@IntoMap
	@ViewModelKey(PosterViewModel::class)
	fun bindsPosterViewModule(
		viewModel: PosterViewModel
	): ViewModel
}