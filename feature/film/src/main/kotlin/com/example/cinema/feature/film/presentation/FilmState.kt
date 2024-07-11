package com.example.cinema.feature.film.presentation

import com.example.cinema.feature.film.presentation.model.FilmUi

sealed interface FilmState {

	data object Initial : FilmState
	data object Loading : FilmState
	data class Failure(val message: String?) : FilmState
	data class Content(
		val film: FilmUi
	) : FilmState
}