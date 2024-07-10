package com.example.cinema.feature.poster.data.converter

import com.example.cinema.feature.poster.data.model.FilmModel
import com.example.cinema.feature.poster.data.model.PosterModel
import com.example.cinema.feature.poster.domain.entity.Film
import javax.inject.Inject

class PosterConverter @Inject constructor(
	private val converter: FilmConverter
) {

	operator fun invoke(model: PosterModel): List<Film> =
		model.films.map { converter(it) }
}

class FilmsConverter @Inject constructor(
	private val filmConverter: FilmConverter
) {

	operator fun invoke(model: List<FilmModel>): List<Film> =
		model.map { filmConverter(it) }
}

class FilmConverter @Inject constructor(
	private val userRatingsConvert: UserRatingsConvert,
	private val countryConverter: CountryConverter,
) {

	operator fun invoke(model: FilmModel): Film =
		Film(
			id = model.id,
			name = model.name,
			originalName = model.originalName,
			releaseDate = model.releaseDate,
			ageRating = model.ageRating,
			genres = model.genres,
			userRatings = userRatingsConvert(model.userRatings),
			img = model.img,
			country = model.country?.let { countryConverter(it) },
		)
}