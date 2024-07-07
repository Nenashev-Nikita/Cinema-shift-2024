package com.example.cinema.shared.film.data.repository

import com.example.cinema.shared.film.data.converter.FilmConverter
import com.example.cinema.shared.film.data.network.FilmApi
import com.example.cinema.shared.film.domain.entity.Film
import com.example.cinema.shared.film.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
	private val api: FilmApi,
	private val filmConverter: FilmConverter,
) : FilmRepository {

	override suspend fun getFilmRepository(id: Long): Film =
		filmConverter(api.get(id))
}