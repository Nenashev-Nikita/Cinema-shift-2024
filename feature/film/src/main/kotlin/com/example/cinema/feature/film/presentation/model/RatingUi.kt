package com.example.cinema.feature.film.presentation.model

import androidx.annotation.StringRes
import com.example.cinema.feature.film.R as FilmR

enum class RatingUi(@StringRes val title: Int) {
	G(
		title = FilmR.string.rating_G
	),
	PG(
		title = FilmR.string.rating_PG
	),
	PG13(
		title = FilmR.string.rating_PG13
	),
	R(
		title = FilmR.string.rating_R
	),
	NC17(
		title = FilmR.string.rating_NC17
	),
}