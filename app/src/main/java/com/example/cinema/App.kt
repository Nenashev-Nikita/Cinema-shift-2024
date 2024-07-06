package com.example.cinema

import android.app.Application
import com.example.cinema.di.AppComponent
import com.example.cinema.di.DaggerAppComponent
import com.example.cinema.feature.poster.di.PosterComponent
import com.example.cinema.feature.poster.di.PosterRoot
import javax.inject.Inject

class App : Application(), PosterRoot {

	private lateinit var appComponent: AppComponent

	@Inject
	override lateinit var posterComponentBuilder: PosterComponent.Builder

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