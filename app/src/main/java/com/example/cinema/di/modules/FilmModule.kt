package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.feature.film.data.network.FilmApi
import com.example.cinema.feature.film.data.repository.FilmRepositoryImpl
import com.example.cinema.feature.film.di.DaggerFilmComponent
import com.example.cinema.feature.film.di.FilmComponent
import com.example.cinema.feature.film.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(
	includes = [FilmDataModule::class]
)
interface FilmModule {

	companion object {

		@Provides
		fun providesFilmDeps(
			deps: FilmComponent.Deps
		): FilmComponent.Builder =
			DaggerFilmComponent
				.builder()
				.deps(deps)
	}
}

@Module
interface FilmDataModule {

	companion object {

		@Provides
		fun provideFilmApi(retrofit: Retrofit): FilmApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindFilmRepository(
		filmRepositoryImpl: FilmRepositoryImpl
	): FilmRepository
}