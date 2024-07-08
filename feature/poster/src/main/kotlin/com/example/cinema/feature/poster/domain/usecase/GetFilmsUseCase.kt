package com.example.cinema.feature.poster.domain.usecase

import com.example.cinema.feature.poster.domain.repository.FilmRepository
import com.example.cinema.feature.poster.domain.entity.Film
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
	private val repository: FilmRepository
) : suspend () -> List<Film> by repository::getAllFilmsRepository