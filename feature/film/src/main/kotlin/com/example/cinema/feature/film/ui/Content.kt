package com.example.cinema.feature.film.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinema.design.component.Button
import com.example.cinema.design.component.PosterItem
import com.example.cinema.design.resources.ui.theme.CinemaTheme
import com.example.cinema.feature.film.R
import com.example.cinema.feature.film.presentation.model.FilmUi

@Composable
fun Content(
	film: FilmUi,
	onFilmClicked: () -> Unit,
) {
	Column(
		modifier = Modifier
			.fillMaxHeight()
			.padding(
				vertical = CinemaTheme.padding.medium,
				horizontal = CinemaTheme.padding.medium
			)
	) {
		Spacer(modifier = Modifier.height(CinemaTheme.padding.medium))

		PosterItem(
			img = film.img,
			genres = film.genres,
			releaseDate = film.releaseDate,
			name = film.name,
			originalName = film.originalName,
			ageRating = stringResource(id = film.ageRating.title),
			userRatings = film.userRatings.kinopoisk.toFloat(),
			country = film.country?.name
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.large))

		DescriptionFilm(
			description = film.description,
		)

		Spacer(modifier = Modifier.weight(1f))

		Button(
			text = stringResource(id = R.string.buttom),
			onClick = { onFilmClicked() },
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.large))
	}
}