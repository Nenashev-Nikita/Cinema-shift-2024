package com.example.cinema.feature.poster.domain.repository

import com.example.cinema.feature.poster.domain.entity.Film

interface FilmRepository {

	suspend fun getAllFilmsRepository(): List<Film>
}