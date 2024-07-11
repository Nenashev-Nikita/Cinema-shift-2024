package com.example.cinema.feature.poster.data.converter

import com.example.cinema.feature.poster.data.model.FilmModel
import com.example.cinema.feature.poster.domain.entity.Film
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
			releaseDate = model.releaseDate,
			ageRating = model.ageRating,
			genres = model.genres,
			userRatings = userRatingsConvert(model.userRatings),
			img = model.img,
			country = model.country?.let { countryConverter(it) },
		)
}