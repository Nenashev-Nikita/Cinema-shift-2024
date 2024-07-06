package com.example.cinema.di.modules

import dagger.Module

@Module(
	includes = [
		HistoryModule::class,
		LoadModule::class,
	]
)
interface MainModule