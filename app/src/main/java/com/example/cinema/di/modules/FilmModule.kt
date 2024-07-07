package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.shared.film.data.network.FilmApi
import com.example.cinema.shared.film.data.repository.FilmRepositoryImpl
import com.example.cinema.shared.film.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface FilmModule {

	companion object {

		@Provides
		fun provideLoadApi(retrofit: Retrofit): FilmApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindLoadRepository(
		filmRepositoryImpl: FilmRepositoryImpl
	): FilmRepository
}