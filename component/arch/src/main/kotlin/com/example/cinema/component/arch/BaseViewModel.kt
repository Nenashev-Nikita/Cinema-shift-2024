package com.example.cinema.component.arch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

	fun launch(block: suspend () -> Unit) {
		viewModelScope.launch {
			block()
		}
	}
}