package com.example.cinema.feature.history.di

import androidx.lifecycle.ViewModel
import com.example.cinema.util.di.ViewModelKey
import com.example.cinema.feature.history.presentation.HistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HistoryModule {

	@Binds
	@IntoMap
	@ViewModelKey(HistoryViewModel::class)
	fun providesHistoryViewModule(
		viewModel: HistoryViewModel
	): ViewModel
}