package com.example.cinema.feature.film

import kotlinx.serialization.Serializable

@Serializable
data class FilmRouter(
	val filmId: Long,
)