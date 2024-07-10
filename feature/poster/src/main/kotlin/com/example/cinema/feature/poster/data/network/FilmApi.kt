package com.example.cinema.feature.poster.data.network

import com.example.cinema.feature.poster.data.model.FilmModel
import com.example.cinema.feature.poster.data.model.PosterModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {

	@GET("today")
	suspend fun getAll(): PosterModel
}