package com.example.cinema.shared.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PosterModel(
	val success: Boolean,
	val reason: String? = null,
	val films: FilmsModel,
)
