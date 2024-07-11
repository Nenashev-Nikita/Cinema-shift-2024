package com.example.cinema.feature.film.presentation.converter

import com.example.cinema.feature.film.domain.entity.Rating
import com.example.cinema.feature.film.presentation.model.RatingUi
import javax.inject.Inject

class RatingUiConverter @Inject constructor() {

	operator fun invoke(entity: Rating): RatingUi =
		RatingUi.entries.find { entity.name == it.name } ?: error("There is no Rating")
}