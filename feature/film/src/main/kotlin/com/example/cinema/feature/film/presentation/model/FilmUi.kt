package com.example.cinema.feature.film.presentation.model

import com.example.cinema.feature.film.domain.entity.Country
import com.example.cinema.feature.film.domain.entity.UserRatings

data class FilmUi (
	val id: String,
	val name: String,
	val originalName: String,
	val description: String,
	val releaseDate: String,
	val ageRating: RatingUi,
	val genres: List<String>,
	val userRatings: UserRatings,
	val img: String,
	val country: Country?,
)