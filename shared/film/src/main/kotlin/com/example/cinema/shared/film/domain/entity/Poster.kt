package com.example.cinema.shared.film.domain.entity

data class Poster(
	val success: Boolean,
	val reason: String,
	val films: Films,
)
