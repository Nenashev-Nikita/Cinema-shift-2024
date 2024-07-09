package com.example.cinema.feature.poster.data.converter

import com.example.cinema.feature.poster.data.model.CountryModel
import com.example.cinema.feature.poster.domain.entity.Country
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