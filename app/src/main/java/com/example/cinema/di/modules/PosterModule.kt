package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.feature.poster.data.network.PosterApi
import com.example.cinema.feature.poster.data.repository.PosterRepositoryImpl
import com.example.cinema.feature.poster.domain.repository.PosterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface PosterModule {

	companion object {

		@Provides
		fun provideLoadApi(retrofit: Retrofit): PosterApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindLoadRepository(
		posterRepositoryImpl: PosterRepositoryImpl
	): PosterRepository
}