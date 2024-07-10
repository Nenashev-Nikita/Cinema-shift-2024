package com.example.cinema.feature.film.presentation.converter

import com.example.cinema.feature.film.domain.entity.Film
import com.example.cinema.feature.film.presentation.model.FilmUi
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
			description = model.description,
			releaseDate = model.releaseDate.takeLast(4),
			ageRating = ratingUiConverter(model.ageRating),
			genres = model.genres,
			userRatings = model.userRatings,
			img = model.img,
			country = model.country,
		)
}