package com.example.cinema.feature.poster.domain.repository

import com.example.cinema.feature.poster.domain.entity.Film

interface PosterRepository {

	suspend fun getAllFilmsRepository(): List<Film>
}