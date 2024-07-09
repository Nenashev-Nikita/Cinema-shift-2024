package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.feature.poster.data.network.FilmApi
import com.example.cinema.feature.poster.data.repository.FilmRepositoryImpl
import com.example.cinema.feature.poster.di.DaggerPosterComponent
import com.example.cinema.feature.poster.di.PosterComponent
import com.example.cinema.feature.poster.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(
	includes = [PosterDataModule::class]
)
interface PosterModule {

	companion object {

		@Provides
		fun providesPosterDeps(
			deps: PosterComponent.Deps
		): PosterComponent.Builder =
			DaggerPosterComponent
				.builder()
				.deps(deps)
	}
}

@Module
interface PosterDataModule {

	companion object {

		@Provides
		fun provideLoadApi(retrofit: Retrofit): FilmApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindLoadRepository(
		filmRepositoryImpl: FilmRepositoryImpl
	): FilmRepository
}