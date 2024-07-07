package com.example.cinema.feature.poster.presentation.model

import androidx.annotation.StringRes
import com.example.cinema.design.compose.R as ComponentR

enum class RatingUi(@StringRes val title: Int) {
	G(
		title = ComponentR.string.rating_G
	),
	PG(
		title = ComponentR.string.rating_PG
	),
	PG13(
		title = ComponentR.string.rating_PG13
	),
	R(
		title = ComponentR.string.rating_R
	),
	NC17(
		title = ComponentR.string.rating_NC17
	),
}