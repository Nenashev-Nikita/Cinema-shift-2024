package com.example.cinema.feature.film.domain.entity

import android.graphics.drawable.Drawable

data class Film(
	val id: String,
	val name: String,
	val originalName: String,
	val description: String,
	val releaseDate: String,
	val ageRating: Rating,
	val genres: List<String>,
	val userRatings: UserRatings,
	val img: String,
	val country: Country?,
)
