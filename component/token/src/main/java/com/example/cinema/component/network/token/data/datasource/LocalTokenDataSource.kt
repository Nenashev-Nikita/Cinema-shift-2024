package com.example.cinema.component.network.token.data.datasource

interface LocalTokenDataSource {

	fun saveToken(token: String)

	fun getToken(): String

	fun clearToken()

	fun isTokenExist(): Boolean
}