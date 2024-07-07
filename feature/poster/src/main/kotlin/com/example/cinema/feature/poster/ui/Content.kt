package com.example.cinema.feature.poster.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinema.design.component.Button
import com.example.cinema.design.component.PosterItem
import com.example.cinema.design.resources.ui.theme.CinemaTheme
import com.example.cinema.feature.poster.R
import com.example.cinema.feature.poster.presentation.model.FilmUi

@Composable
fun Content(
	films: List<FilmUi>,
//	applyIntent: () -> Unit
) {
	LazyColumn(
		modifier = Modifier
			.fillMaxHeight()
			.padding(
				vertical = CinemaTheme.padding.medium,
				horizontal = CinemaTheme.padding.medium
			)
	) {
		items(films) {
			Spacer(modifier = Modifier.height(CinemaTheme.padding.medium))

			PosterItem(
				img = it.img,
				genres = it.genres,
				releaseDate = it.releaseDate,
				name = it.name,
				originalName = it.originalName,
				ageRating = stringResource(id = it.ageRating.title),
				userRatings = it.userRatings.kinopoisk.toFloat(),
				country = it.country?.name
			)

			Spacer(modifier = Modifier.height(CinemaTheme.padding.medium))

			Button(
				text = stringResource(id = R.string.buttom),
				onClick = { /*TODO*/ },
			)

			Spacer(modifier = Modifier.height(CinemaTheme.padding.large))
		}
	}
}
