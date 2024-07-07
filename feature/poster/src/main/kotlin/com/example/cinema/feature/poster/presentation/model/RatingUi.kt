package com.example.cinema.feature.poster.presentation.model

import androidx.annotation.StringRes
import com.example.cinema.feature.poster.R as PosterR

enum class RatingUi(@StringRes val title: Int) {
	G(
		title = PosterR.string.rating_G
	),
	PG(
		title = PosterR.string.rating_PG
	),
	PG13(
		title = PosterR.string.rating_PG13
	),
	R(
		title = PosterR.string.rating_R
	),
	NC17(
		title = PosterR.string.rating_NC17
	),
}