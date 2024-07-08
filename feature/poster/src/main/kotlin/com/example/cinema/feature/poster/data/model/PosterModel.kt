package com.example.cinema.feature.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PosterModel(
	val films: List<FilmModel>
)
