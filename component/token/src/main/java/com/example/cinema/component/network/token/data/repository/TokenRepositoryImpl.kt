package com.example.cinema.component.network.token.data.repository

import com.example.cinema.component.network.token.data.datasource.LocalTokenDataSource
import com.example.cinema.component.network.token.domain.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
	private val localDataSource: LocalTokenDataSource,
) : TokenRepository {

	override fun getToken(): String =

		localDataSource.getToken()

	override fun clearToken() {
		localDataSource.clearToken()
	}

	override fun isTokenExist(): Boolean =
		localDataSource.isTokenExist()
}