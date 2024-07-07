package com.example.cinema.feature.poster.data.network

import com.example.cinema.feature.poster.data.model.PosterModel
import retrofit2.http.GET

interface PosterApi {

	@GET("today")
	suspend fun getAll(): List<PosterModel>
}