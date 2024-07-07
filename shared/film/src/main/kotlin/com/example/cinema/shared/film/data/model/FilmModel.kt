package com.example.cinema.shared.film.data.model

import com.example.cinema.shared.film.data.converter.LocalDateTimeSerializer
import com.example.cinema.shared.film.domain.entity.Rating
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class FilmModel(
	val id: Int,
	val name: String,
	val originalName: String,
	val description: String,
	@Serializable(LocalDateTimeSerializer::class)
	val releaseDate: LocalDateTime,
	val actor: List<ActorModel>,
	val directors: DirectionsModel,
	val runtime: Int,
	val ageRating: Rating,
	val genres: List<String>,
	val userRatings: UserRatingsModels,
	val img: String,
	val country: CountryModel? = null,
)
