package com.example.cinema.shared.film.domain.repository

import com.example.cinema.shared.film.domain.entity.Film

interface FilmRepository {

	suspend fun getFilmRepository(id: Long): Film
}