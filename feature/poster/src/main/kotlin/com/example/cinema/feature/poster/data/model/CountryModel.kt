package com.example.cinema.feature.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryModel(
	val name: String,
	val code: String,
	val code2: String,
	val id: Int,
)
