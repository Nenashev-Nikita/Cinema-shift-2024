package com.example.cinema.feature.film.data.repository

import com.example.cinema.feature.film.data.converter.FilmResponseConverter
import com.example.cinema.feature.film.data.network.FilmApi
import com.example.cinema.feature.film.domain.entity.Film
import com.example.cinema.feature.film.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
	private val api: FilmApi,
	private val filmResponseConverter: FilmResponseConverter
) : FilmRepository {

	override suspend fun getFilmRepository(id: Long): Film =
		filmResponseConverter(api.get(id))
}