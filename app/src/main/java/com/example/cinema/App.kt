package com.example.cinema

import android.app.Application
import com.example.cinema.di.AppComponent
import com.example.cinema.di.DaggerAppComponent
import com.example.cinema.feature.history.di.HistoryRoot
import com.example.cinema.feature.history.di.HistoryComponent
import javax.inject.Inject

class App : Application(), HistoryRoot {

	private lateinit var appComponent: AppComponent

	@Inject
	override lateinit var historyComponentBuilder: HistoryComponent.Builder

	override fun onCreate() {
		super.onCreate()
		appComponent = initDagger()
		appComponent.inject(this)
	}

	private fun initDagger(): AppComponent {
		return DaggerAppComponent
			.factory()
			.create(this)
	}
}