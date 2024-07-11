package com.example.cinema.di.modules

import dagger.Module

@Module(
	includes = [
		PosterModule::class,
		FilmModule::class,
	]
)
interface MainModule