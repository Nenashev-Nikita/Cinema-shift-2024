package com.example.cinema.feature.history.di

import com.example.cinema.shared.loan.domain.usecase.GetLoanHistoryItemsUseCase
import dagger.Component
import javax.inject.Inject

@Component(
	dependencies = [HistoryComponent.Deps::class],
	modules = [HistoryModule::class],
)
interface HistoryComponent {

	fun inject(viewModel: HistoryComponentViewModel)

	@Component.Builder
	interface Builder {

		fun deps(deps: Deps): Builder

		fun build(): HistoryComponent
	}

	class Deps @Inject constructor(
		val getLoanHistoryItemsUseCase: GetLoanHistoryItemsUseCase,
	)
}