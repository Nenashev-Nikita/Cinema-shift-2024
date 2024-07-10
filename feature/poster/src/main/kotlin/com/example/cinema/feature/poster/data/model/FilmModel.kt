package com.example.cinema.feature.poster.data.model

import com.example.cinema.feature.poster.domain.entity.Rating
import kotlinx.serialization.Serializable

@Serializable
data class FilmModel(
	val id: String,
	val name: String,
	val originalName: String,
	val releaseDate: String,
	val ageRating: Rating,
	val genres: List<String>,
	val userRatings: UserRatingsModels,
	val img: String,
	val country: CountryModel? = null,
)