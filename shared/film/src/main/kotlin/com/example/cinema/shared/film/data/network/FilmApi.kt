package com.example.cinema.shared.film.data.network

import com.example.cinema.shared.film.data.model.FilmModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {

	@GET("film/{filmId}")
	suspend fun get(@Path("filmId") filmId: Long): FilmModel
}