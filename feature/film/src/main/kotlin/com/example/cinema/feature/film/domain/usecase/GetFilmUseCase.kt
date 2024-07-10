package com.example.cinema.feature.film.domain.usecase

import com.example.cinema.feature.film.domain.entity.Film
import com.example.cinema.feature.film.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
	private val repository: FilmRepository
) : suspend (Long) -> Film by repository::getFilmRepository