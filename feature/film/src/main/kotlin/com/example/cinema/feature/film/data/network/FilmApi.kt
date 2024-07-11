package com.example.cinema.feature.film.data.network

import com.example.cinema.feature.film.data.model.FilmResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {

	@GET("film/{filmId}")
	suspend fun get(@Path("filmId") filmId: Long): FilmResponseModel
}