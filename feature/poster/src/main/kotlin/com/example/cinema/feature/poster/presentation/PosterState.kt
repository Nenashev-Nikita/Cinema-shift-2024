package com.example.cinema.feature.poster.presentation

import com.example.cinema.feature.poster.presentation.model.FilmUi

sealed interface PosterState {

	data object Initial : PosterState
	data object Loading : PosterState
	data class Failure(val message: String?) : PosterState
	data class Content(
		val films: List<FilmUi>
	) : PosterState
}