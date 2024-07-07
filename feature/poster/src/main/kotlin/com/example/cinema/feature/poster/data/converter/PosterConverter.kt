package com.example.cinema.feature.poster.data.converter

import com.example.cinema.feature.poster.data.model.PosterModel
import com.example.cinema.feature.poster.domain.entity.Poster
import com.example.cinema.shared.film.data.converter.FilmConverter
import javax.inject.Inject

class PosterConverter @Inject constructor(
	private val filmConverter: FilmConverter
) {

	operator fun invoke(model: List<PosterModel>): List<Poster> =
		model.map {
			toPoster(
				model = it,
				filmConverter = filmConverter
			)
		}
}

private fun toPoster(
	model: PosterModel,
	filmConverter: FilmConverter,
): Poster =
	Poster(
		success = model.success,
		reason = model.reason,
		film = filmConverter(model.film),
	)