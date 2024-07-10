package com.example.cinema.feature.poster.presentation.model

import com.example.cinema.feature.poster.domain.entity.Country
import com.example.cinema.feature.poster.domain.entity.UserRatings

data class FilmUi (
	val id: String,
	val name: String,
	val originalName: String,
	val releaseDate: String,
	val ageRating: RatingUi,
	val genres: List<String>,
	val userRatings: UserRatings,
	val img: String,
	val country: Country?,
)