package com.example.cinema.di

import android.content.Context
import com.example.cinema.App
import com.example.cinema.di.modules.MainModule
import com.example.cinema.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(
	modules = [
		MainModule::class,
		NetworkModule::class,
	]
)
interface AppComponent {

	fun inject(app: App)

	@Component.Factory
	interface Factory {

		fun create(
			@BindsInstance appContext: Context,
		): AppComponent
	}
}