package com.example.cinema.component.network.token.domain.repository

interface TokenRepository {

	fun getToken(): String

	fun clearToken()

	fun isTokenExist(): Boolean
}