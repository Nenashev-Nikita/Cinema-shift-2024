package com.example.cinema.shared.film.data.model

import kotlinx.serialization.Serializable

@Serializable
class DirectionsModel (
	val id: Int,
	val professions: String,
	val fullName: String,
)