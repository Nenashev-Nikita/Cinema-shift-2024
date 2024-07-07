package com.example.cinema.feature.poster.domain.entity

import com.example.cinema.shared.film.domain.entity.Film

data class Poster(
	val success: Boolean,
	val reason: String? = null,
	val film: Film,
)
