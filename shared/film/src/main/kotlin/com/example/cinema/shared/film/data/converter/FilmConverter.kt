package com.example.cinema.shared.film.data.converter

import com.example.cinema.shared.film.data.model.FilmModel
import com.example.cinema.shared.film.domain.entity.Film
import javax.inject.Inject

class FilmConverter @Inject constructor(
	private val directorsConvert: DirectorsConvert,
	private val actorsConvert: ActorsConvert,
	private val userRatingsConvert: UserRatingsConvert,
) {

	operator fun invoke(model: FilmModel): Film =
		Film(
			id = model.id,
			name = model.name,
			originalName = model.originalName,
			description = model.description,
			releaseDate = model.releaseDate,
			actor = actorsConvert(model.actor),
			directors = directorsConvert(model.directors),
			runtime = model.runtime,
			ageRating = model.ageRating,
			genres = model.genres,
			userRatings = userRatingsConvert(model.userRatings),
			img = model.img,
			country = model.country,
		)
}