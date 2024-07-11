package com.example.cinema.feature.poster.presentation.converter

import com.example.cinema.feature.poster.domain.entity.Film
import com.example.cinema.feature.poster.presentation.model.FilmUi
import javax.inject.Inject

class FilmsUiConverter @Inject constructor(
	private val filmUiConverter: FilmUiConverter,
) {

	operator fun invoke(model: List<Film>): List<FilmUi> =
		model.map { filmUiConverter(it) }
}

class FilmUiConverter @Inject constructor(
	private val ratingUiConverter: RatingUiConverter,
) {

	operator fun invoke(model: Film): FilmUi =
		FilmUi(
			id = model.id,
			name = model.name,
			originalName = model.originalName,
			releaseDate = model.releaseDate.takeLast(4),
			ageRating = ratingUiConverter(model.ageRating),
			genres = model.genres,
			userRatings = model.userRatings,
			img = model.img,
			country = model.country,
		)
}