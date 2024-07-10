package com.example.cinema.feature.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRatingsModels(
	val kinopoisk: String,
	val imdb: String,
)
