package com.example.cinema.di.modules

import dagger.Module

@Module(
	includes = [
		HistoryModule::class,
		LoadModule::class,
		FilmModule::class,
	]
)
interface MainModule