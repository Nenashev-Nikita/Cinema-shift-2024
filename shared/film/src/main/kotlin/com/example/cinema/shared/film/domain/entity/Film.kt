package com.example.cinema.shared.film.domain.entity

import com.example.cinema.shared.film.data.model.CountryModel
import java.time.LocalDateTime

data class Film(
	val id: Int,
	val name: String,
	val originalName: String,
	val description: String,
	val releaseDate: LocalDateTime,
	val actor: List<Actor>,
	val directors: Directors,
	val runtime: Int,
	val ageRating: Rating,
	val genres: List<String>,
	val userRatings: UserRatings,
	val img: String,
	val country: CountryModel?,
)
