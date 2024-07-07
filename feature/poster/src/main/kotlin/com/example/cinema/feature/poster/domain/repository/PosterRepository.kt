package com.example.cinema.feature.poster.domain.repository

import com.example.cinema.feature.poster.domain.entity.Poster

interface PosterRepository {

	suspend fun getPosterRepository(): List<Poster>
}