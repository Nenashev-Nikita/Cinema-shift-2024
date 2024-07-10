package com.example.cinema.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinema.design.compose.R
import com.example.cinema.design.resources.ui.theme.CinemaTheme

private const val IMG_URL = "https://shift-backend.onrender.com"

@Composable
fun PosterItem(
	img: String,
	genres: List<String>,
	releaseDate: String,
	name: String,
	originalName: String,
	ageRating: String,
	userRatings: Float,
	country: String? = null,
) {
	Column(Modifier.fillMaxWidth()) {
		CardCinema(
			img = img,
			genres = genres,
			releaseDate = releaseDate,
			country = country,
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.medium))

		NameFilm(
			name = name,
			ageRating = ageRating,
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.extraSmall))

		SubtitleFilm(
			name = originalName
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.medium))

		RatingsFilm(userRatings = userRatings)
	}
}

@Composable
private fun CardCinema(
	img: String,
	genres: List<String>,
	releaseDate: String,
	country: String? = null,
) {
	Box {
		Image(
			painter = rememberAsyncImagePainter(IMG_URL + img),
			contentDescription = null,
			modifier = Modifier
				.size(300.dp)
				.clip(RoundedCornerShape(CinemaTheme.shapes.medium)),
			contentScale = ContentScale.FillBounds,
		)
		Box(
			modifier = Modifier
				.align(Alignment.BottomEnd)
				.clip(RoundedCornerShape(topStart = CinemaTheme.shapes.medium))
		) {
			DetailsFilm(
				genres = genres,
				releaseDate = releaseDate,
				country = country,
			)
		}
	}
}

@Composable
private fun DetailsFilm(
	genres: List<String>,
	releaseDate: String,
	country: String? = null,
) {
	Column(
		modifier = Modifier
			.background(CinemaTheme.colors.secondary)
			.padding(
				horizontal = CinemaTheme.padding.medium,
				vertical = CinemaTheme.padding.small
			),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		Text(
			text = genres.first(),
			color = CinemaTheme.colors.textPrimary,
			style = CinemaTheme.typography.paragraph.copy(fontWeight = FontWeight(500)),
		)

		Spacer(modifier = Modifier.height(CinemaTheme.padding.extraSmall))

		Text(
			text = stringResource(
				id = R.string.film_detail,
				releaseDate,
				country ?: "",
			),
			color = CinemaTheme.colors.textPrimary,
			style = CinemaTheme.typography.paragraph,
		)
	}
}

@Composable
fun NameFilm(
	name: String,
	ageRating: String,
) {
	Text(
		text = stringResource(
			id = R.string.film_name,
			name,
			ageRating,
		),
		color = CinemaTheme.colors.textPrimary,
		style = CinemaTheme.typography.titleMedium,
	)
}

@Composable
fun SubtitleFilm(
	name: String,
) {
	Text(
		text = name,
		color = CinemaTheme.colors.textTertiary,
		style = CinemaTheme.typography.regular,
	)
}

@Composable
fun RatingsFilm(
	userRatings: Float
) {
	Column {
		RatingBar(rating = userRatings.toDouble())

		Text(
			text = stringResource(
				id = R.string.film_rating,
				stringResource(id = R.string.kinopoisk),
				userRatings
			),
			color = CinemaTheme.colors.textTertiary,
			style = CinemaTheme.typography.regular,
		)
	}
}

@Composable
fun RatingBar(
	rating: Double = 0.0,
	modifier: Modifier = Modifier,
) {

	var isHalfStar = (rating % 1) != 0.0
	Row(modifier = modifier) {
		for (index in 1..5) {
			if (index <= rating / 2) {
				Star(
					star = ImageVector.vectorResource(id = R.drawable.star),
				)
			} else {
				if (isHalfStar) {
					isHalfStar = false
					Star(
						star = ImageVector.vectorResource(id = R.drawable.star_half),
					)
				} else {
					Star(
						star = ImageVector.vectorResource(id = R.drawable.star_full),
					)
				}
			}
		}
	}
}

@Composable
fun Star(
	star: ImageVector
) {
	Image(
		imageVector = star,
		contentDescription = null,
		modifier = Modifier.size(48.dp)
	)
}

@Preview
@Composable
fun Preview() {
	Screen {

	}
}
