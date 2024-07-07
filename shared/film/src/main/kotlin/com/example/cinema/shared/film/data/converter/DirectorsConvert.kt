package com.example.cinema.shared.film.data.converter

import com.example.cinema.shared.film.data.model.DirectionsModel
import com.example.cinema.shared.film.domain.entity.Directors
import javax.inject.Inject

class DirectorsConvert @Inject constructor(
	private val professionsConvert: ProfessionsConvert
) {

	operator fun invoke(model: DirectionsModel): Directors =
		Directors(
			id = model.id,
			professions = professionsConvert(model.professions),
			fullName = model.fullName,
		)
}