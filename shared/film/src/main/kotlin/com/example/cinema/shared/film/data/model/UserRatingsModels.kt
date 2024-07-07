package com.example.cinema.shared.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRatingsModels(
	val kinopoisk: String,
	val imdb: String,
)
