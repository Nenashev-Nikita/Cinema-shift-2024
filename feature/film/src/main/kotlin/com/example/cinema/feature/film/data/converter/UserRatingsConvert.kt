package com.example.cinema.feature.film.data.converter

import com.example.cinema.feature.film.data.model.UserRatingsModels
import com.example.cinema.feature.film.domain.entity.UserRatings
import javax.inject.Inject

class UserRatingsConvert @Inject constructor() {

	operator fun invoke(models: UserRatingsModels): UserRatings =
		UserRatings(
			kinopoisk = models.kinopoisk,
			imdb = models.imdb,
		)
}