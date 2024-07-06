package com.example.cinema.component.network.token.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject

class LocalTokenDataSourceImpl @Inject constructor(
	private val sharedPreferences: SharedPreferences,
) : LocalTokenDataSource {

	internal companion object {

		const val TOKEN_SHARED_PREF = "TOKEN_SHARED_PREF"
		private const val TOKEN_KEY = "TOKEN_KEY"
	}

	override fun saveToken(token: String) {
		sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
	}

	override fun getToken(): String =
		sharedPreferences.getString(TOKEN_KEY, "") ?: ""

	override fun clearToken() {
		sharedPreferences.edit().remove(TOKEN_KEY).apply()
	}

	override fun isTokenExist(): Boolean =
		sharedPreferences.contains(TOKEN_KEY)
}