package com.example.cinema.shared.film.data.converter

import com.example.cinema.shared.film.data.model.ActorModel
import com.example.cinema.shared.film.domain.entity.Actor
import com.example.cinema.shared.film.domain.entity.Professions
import javax.inject.Inject

class ActorsConvert @Inject constructor() {

	operator fun invoke(model: List<ActorModel>): List<Actor> =
		model.map { toActor(it) }
}

private fun toActor(model: ActorModel): Actor =
	Actor(
		id = model.id.toInt(),
		professions = Professions.ACTOR,
		fullName = model.fullName,
	)