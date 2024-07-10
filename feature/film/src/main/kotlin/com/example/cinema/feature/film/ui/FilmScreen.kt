package com.example.cinema.feature.film.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinema.design.component.AppBar
import com.example.cinema.design.component.Error
import com.example.cinema.design.component.Loading
import com.example.cinema.feature.film.R
import com.example.cinema.feature.film.di.FilmComponentViewModule
import com.example.cinema.feature.film.di.FilmRoot
import com.example.cinema.feature.film.presentation.FilmState
import com.example.cinema.feature.film.presentation.FilmViewModel
import com.example.cinema.util.di.findActivity

@Composable
fun FilmScreen(
	filmId: Long,
) {

	val context = LocalContext.current
	val component = (context.findActivity().application as? FilmRoot)?.filmComponentBuilder?.build()

	val componentViewModel: FilmComponentViewModule = viewModel()

	component?.inject(componentViewModel)

	val filmViewModel: FilmViewModel = viewModel(factory = componentViewModel.viewModelFactory)
	val filmState by filmViewModel.state.collectAsState()

	LaunchedEffect(Unit) {
		filmViewModel.loadFilm(filmId)
	}

	Column(modifier = Modifier.fillMaxSize()) {
		AppBar(
			leftIcon = ImageVector.vectorResource(id = R.drawable.line)
		)

		when (val state = filmState) {
			is FilmState.Initial,
			is FilmState.Loading -> Loading()

			is FilmState.Failure -> Error(
				message = state.message ?: "",
				onRetry = { filmViewModel.loadFilm(filmId) },
			)

			is FilmState.Content -> Content(
				film = state.film,
				onFilmClicked = {}
			)
		}
	}
}