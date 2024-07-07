package com.example.cinema.feature.poster.presentation.converter

import com.example.cinema.feature.poster.domain.entity.Rating
import com.example.cinema.feature.poster.presentation.model.RatingUi
import javax.inject.Inject

class RatingUiConverter @Inject constructor() {

	operator fun invoke(entity: Rating): RatingUi =
		RatingUi.entries.find { entity.name == it.name } ?: error("There is no Rating")
}