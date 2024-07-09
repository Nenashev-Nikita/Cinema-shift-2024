package com.example.cinema.feature.poster.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinema.design.component.Error
import com.example.cinema.design.component.Loading
import com.example.cinema.design.component.Screen
import com.example.cinema.feature.poster.di.PosterComponentViewModel
import com.example.cinema.feature.poster.di.PosterRoot
import com.example.cinema.feature.poster.presentation.PosterState
import com.example.cinema.feature.poster.presentation.PosterViewModel
import com.example.cinema.util.di.findActivity

@Composable
fun PosterScreen() {
	val context = LocalContext.current
	val component = (context.findActivity().application as? PosterRoot)?.posterComponentBuilder?.build()

	val componentViewModel: PosterComponentViewModel = viewModel()

	component?.inject(componentViewModel)

	val posterViewModel: PosterViewModel = viewModel(factory = componentViewModel.viewModelFactory)
	val posterState by posterViewModel.state.collectAsState()

	LaunchedEffect(Unit) {
		posterViewModel.loadPoster()
	}

	Column(modifier = Modifier.fillMaxSize()) {

		when (val state = posterState) {
			is PosterState.Initial,
			is PosterState.Loading -> Loading()

			is PosterState.Failure -> Error(
				message = state.message ?: "",
				onRetry = { posterViewModel.loadPoster() },
			)

			is PosterState.Content -> Content(state.films)
		}
	}
}