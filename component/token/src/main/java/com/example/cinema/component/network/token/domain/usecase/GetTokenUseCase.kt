package com.example.cinema.component.network.token.domain.usecase

import com.example.cinema.component.network.token.domain.repository.TokenRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
	private val repository: TokenRepository,
) : () -> String by repository::getToken