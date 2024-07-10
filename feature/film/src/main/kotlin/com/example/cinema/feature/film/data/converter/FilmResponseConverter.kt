package com.example.cinema.feature.film.data.converter

import com.example.cinema.feature.film.data.FilmConverter
import com.example.cinema.feature.film.data.model.FilmResponseModel
import com.example.cinema.feature.film.domain.entity.Film
import javax.inject.Inject

class FilmResponseConverter @Inject constructor(
	private val converter: FilmConverter
) {

	operator fun invoke(model: FilmResponseModel): Film =
		converter(model.film)
}