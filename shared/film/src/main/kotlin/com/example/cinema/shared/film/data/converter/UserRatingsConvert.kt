package com.example.cinema.shared.film.data.converter

import com.example.cinema.shared.film.data.model.UserRatingsModels
import com.example.cinema.shared.film.domain.entity.UserRatings
import javax.inject.Inject

class UserRatingsConvert @Inject constructor() {

	operator fun invoke(models: UserRatingsModels): UserRatings =
		UserRatings(
			kinopoisk = models.kinopoisk,
			imdb = models.imdb,
		)
}

fun UserRatingsModels.userRatings(): UserRatings =
	UserRatings(
		kinopoisk = kinopoisk,
		imdb = imdb,
	)