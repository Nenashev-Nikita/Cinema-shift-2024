package com.example.cinema.feature.poster.data.model

import com.example.cinema.shared.film.data.model.FilmModel
import kotlinx.serialization.Serializable

@Serializable
data class PosterModel(
	val success: Boolean,
	val reason: String? = null,
	val film: FilmModel,
)
