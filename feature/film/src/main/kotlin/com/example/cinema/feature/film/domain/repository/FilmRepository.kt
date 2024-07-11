package com.example.cinema.feature.film.domain.repository

import com.example.cinema.feature.film.domain.entity.Film

interface FilmRepository {

	suspend fun getFilmRepository(id: Long): Film
}