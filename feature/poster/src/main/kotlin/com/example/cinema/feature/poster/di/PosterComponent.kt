package com.example.cinema.feature.poster.di

import com.example.cinema.feature.poster.domain.usecase.GetFilmsUseCase
import dagger.Component
import javax.inject.Inject

@Component(
	dependencies = [PosterComponent.Deps::class],
	modules = [PosterModule::class],
)
interface PosterComponent {

	fun inject(viewModel: PosterComponentViewModel)

	@Component.Builder
	interface Builder {

		fun deps(deps: Deps): Builder

		fun build(): PosterComponent
	}

	class Deps @Inject constructor(
		val getFilmsUseCase: GetFilmsUseCase
	)
}