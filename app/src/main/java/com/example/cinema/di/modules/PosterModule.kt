package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.feature.poster.data.network.PosterApi
import com.example.cinema.feature.poster.data.repository.PosterRepositoryImpl
import com.example.cinema.feature.poster.di.DaggerPosterComponent
import com.example.cinema.feature.poster.di.PosterComponent
import com.example.cinema.feature.poster.domain.repository.PosterRepository
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
		fun providePosterApi(retrofit: Retrofit): PosterApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindPosterRepository(
		posterRepositoryImpl: PosterRepositoryImpl
	): PosterRepository
}