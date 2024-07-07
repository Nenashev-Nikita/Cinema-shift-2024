package com.example.cinema.shared.film.domain.usecase

import com.example.cinema.shared.film.domain.entity.Film
import com.example.cinema.shared.film.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
	private val repository: FilmRepository
) : suspend (Long) -> Film by repository::getFilmRepository