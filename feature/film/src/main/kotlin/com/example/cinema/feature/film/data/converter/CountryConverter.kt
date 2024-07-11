package com.example.cinema.feature.film.data

import com.example.cinema.feature.film.data.model.CountryModel
import com.example.cinema.feature.film.domain.entity.Country
import javax.inject.Inject

class CountryConverter @Inject constructor() {

	operator fun invoke(model: CountryModel): Country =
		Country(
			name = model.name,
			code = model.code,
			code2 = model.code2,
			id = model.id,
		)
}