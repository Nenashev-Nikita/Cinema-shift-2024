package com.example.cinema.component.network.token.domain.usecase

import com.example.cinema.component.network.token.domain.repository.TokenRepository
import javax.inject.Inject

class IsTokenExistUseCase @Inject constructor(
	private val repository: TokenRepository,
) : () -> Boolean by repository::isTokenExist