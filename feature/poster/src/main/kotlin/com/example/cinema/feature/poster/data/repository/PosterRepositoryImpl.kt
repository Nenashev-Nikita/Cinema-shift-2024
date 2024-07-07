package com.example.cinema.feature.poster.data.repository

import com.example.cinema.feature.poster.data.converter.PosterConverter
import com.example.cinema.feature.poster.data.network.PosterApi
import com.example.cinema.feature.poster.domain.entity.Poster
import com.example.cinema.feature.poster.domain.repository.PosterRepository
import javax.inject.Inject

class PosterRepositoryImpl @Inject constructor(
	private val api : PosterApi,
	private val posterConverter: PosterConverter,
): PosterRepository {

	override suspend fun getPosterRepository(): List<Poster> =
		posterConverter(api.getAll())
}