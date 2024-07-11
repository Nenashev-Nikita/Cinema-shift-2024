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