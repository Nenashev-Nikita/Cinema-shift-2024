package com.example.cinema.feature.film.data

import com.example.cinema.feature.film.data.converter.UserRatingsConvert
import com.example.cinema.feature.film.data.model.FilmModel
import com.example.cinema.feature.film.domain.entity.Film
import javax.inject.Inject

class FilmConverter @Inject constructor(
	private val userRatingsConvert: UserRatingsConvert,
	private val countryConverter: CountryConverter,
) {

	operator fun invoke(model: FilmModel): Film =
		Film(
			id = model.id,
			name = model.name,
			originalName = model.originalName,
			description = model.description,
			releaseDate = model.releaseDate,
			ageRating = model.ageRating,
			genres = model.genres,
			userRatings = userRatingsConvert(model.userRatings),
			img = model.img,
			country = model.country?.let { countryConverter(it) },
		)
}