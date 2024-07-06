package com.example.cinema.di.modules

import com.example.cinema.feature.history.di.DaggerHistoryComponent
import com.example.cinema.feature.history.di.HistoryComponent
import dagger.Module
import dagger.Provides

@Module
interface HistoryModule {

	companion object {

		@Provides
		fun providesHistoryDeps(
			deps: HistoryComponent.Deps
		): HistoryComponent.Builder =
			DaggerHistoryComponent
				.builder()
				.deps(deps)
	}
}