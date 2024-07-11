package com.example.cinema.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cinema.feature.film.FilmRouter
import com.example.cinema.feature.film.ui.FilmScreen
import com.example.cinema.feature.poster.PosterRouter
import com.example.cinema.feature.poster.ui.PosterScreen

@Composable
fun MainScreen() {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = PosterRouter) {
			composable<PosterRouter> {
				PosterScreen(
					onFilmSelected = { navController.navigate(FilmRouter(filmId = it)) }
				)
			}
			composable<FilmRouter> {
				val destination = it.toRoute<FilmRouter>()
				FilmScreen(
					filmId = destination.filmId,
					onClickActionBar = { navController.navigate(PosterRouter) }
				)
			}
		}
	}
}