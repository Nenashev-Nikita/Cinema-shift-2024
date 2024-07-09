package com.example.cinema.component.network.token.di

import android.content.Context
import android.content.SharedPreferences
import com.example.cinema.component.network.token.data.datasource.LocalTokenDataSource
import com.example.cinema.component.network.token.data.datasource.LocalTokenDataSourceImpl
import com.example.cinema.component.network.token.data.datasource.LocalTokenDataSourceImpl.Companion.TOKEN_SHARED_PREF
import com.example.cinema.component.network.token.data.repository.TokenRepositoryImpl
import com.example.cinema.component.network.token.domain.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface TokenModule {

	companion object {

		@Provides
		fun provideSharedPreferences(context: Context): SharedPreferences =
			context.getSharedPreferences(TOKEN_SHARED_PREF, Context.MODE_PRIVATE)

		@Provides
		fun providerTokenDataSource(
			sharedPreferences: SharedPreferences,
		): LocalTokenDataSource =
			LocalTokenDataSourceImpl(
				sharedPreferences = sharedPreferences
			)
	}

	@Binds
	fun bindTokenRepository(
		tokenRepositoryImpl: TokenRepositoryImpl
	): TokenRepository
}