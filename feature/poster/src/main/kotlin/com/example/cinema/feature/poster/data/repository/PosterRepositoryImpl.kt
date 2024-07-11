package com.example.cinema.feature.poster.data.repository

import com.example.cinema.feature.poster.data.network.PosterApi
import com.example.cinema.feature.poster.domain.repository.PosterRepository
import com.example.cinema.feature.poster.data.converter.PosterConverter
import com.example.cinema.feature.poster.domain.entity.Film
import javax.inject.Inject

class PosterRepositoryImpl @Inject constructor(
	private val api: PosterApi,
	private val posterConverter: PosterConverter,
) : PosterRepository {

	override suspend fun getAllFilmsRepository(): List<Film> =
		posterConverter(api.getAll())
}