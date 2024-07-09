package com.example.cinema.feature.poster.data.repository

import com.example.cinema.feature.poster.data.converter.FilmsConverter
import com.example.cinema.feature.poster.data.network.FilmApi
import com.example.cinema.feature.poster.domain.repository.FilmRepository
import com.example.cinema.feature.poster.data.converter.FilmConverter
import com.example.cinema.feature.poster.data.converter.PosterConverter
import com.example.cinema.feature.poster.domain.entity.Film
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
	private val api: FilmApi,
	private val posterConverter: PosterConverter,
) : FilmRepository {

	override suspend fun getAllFilmsRepository(): List<Film> =
		posterConverter(api.getAll())
}