package com.example.cinema.feature.poster.presentation.converter

import org.openjdk.tools.doclint.Entity
import javax.inject.Inject

class DateConverter @Inject constructor() {

	operator fun invoke(date: String): String =
			date.takeLast(4)
}