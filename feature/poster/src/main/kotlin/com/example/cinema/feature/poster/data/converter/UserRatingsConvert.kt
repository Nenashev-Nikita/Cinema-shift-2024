package com.example.cinema.feature.poster.data.converter

import com.example.cinema.feature.poster.data.model.UserRatingsModels
import com.example.cinema.feature.poster.domain.entity.UserRatings
import javax.inject.Inject

class UserRatingsConvert @Inject constructor() {

	operator fun invoke(models: UserRatingsModels): UserRatings =
		UserRatings(
			kinopoisk = models.kinopoisk,
			imdb = models.imdb,
		)
}