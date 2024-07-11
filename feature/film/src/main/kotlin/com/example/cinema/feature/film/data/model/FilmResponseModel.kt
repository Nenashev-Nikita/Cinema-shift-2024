package com.example.cinema.feature.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FilmResponseModel(
	val film: FilmModel
)
