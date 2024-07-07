package com.example.cinema.shared.film.data.converter

import com.example.cinema.shared.film.domain.entity.Professions
import javax.inject.Inject

class ProfessionsConvert @Inject constructor() {

	operator fun invoke(model: String): Professions =
		Professions.entries.find { it.name == model } ?: error("There is no Direction")

}

fun String.toProfessions(): Professions =
	Professions.entries.find { it.name == this } ?: error("There is no Direction")