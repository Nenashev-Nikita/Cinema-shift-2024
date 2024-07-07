package com.example.cinema.feature.poster.domain.usecase

import com.example.cinema.feature.poster.domain.entity.Poster
import com.example.cinema.feature.poster.domain.repository.PosterRepository
import javax.inject.Inject

class GetPostersUseCase @Inject constructor(
	private val repository: PosterRepository
) : suspend () -> List<Poster> by repository::getPosterRepository