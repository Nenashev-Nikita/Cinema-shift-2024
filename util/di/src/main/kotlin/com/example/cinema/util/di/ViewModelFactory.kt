package com.example.cinema.util.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
	private val viewModel: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		val viewModelProvider = viewModel[modelClass]
			?: throw IllegalArgumentException("viewModel $modelClass not found")
		return viewModelProvider.get() as T
	}
}