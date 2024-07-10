package com.example.cinema.feature.film.di

import com.example.cinema.feature.film.domain.usecase.GetFilmUseCase
import dagger.Component
import javax.inject.Inject

@Component(
	dependencies = [FilmComponent.Deps::class],
	modules = [FilmModule::class],
)
interface FilmComponent {

	fun inject(viewModel: FilmComponentViewModule)

	@Component.Builder
	interface Builder {

		fun deps(deps: Deps): Builder

		fun build(): FilmComponent
	}

	class Deps @Inject constructor(
		val getFilmUseCase: GetFilmUseCase
	)
}