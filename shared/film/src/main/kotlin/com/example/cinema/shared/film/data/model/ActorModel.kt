package com.example.cinema.shared.film.data.model

import com.example.cinema.shared.film.domain.entity.Professions
import kotlinx.serialization.Serializable

@Serializable
data class ActorModel(
	val id: String,
	val professions: List<Professions>,
	val fullName: String
)