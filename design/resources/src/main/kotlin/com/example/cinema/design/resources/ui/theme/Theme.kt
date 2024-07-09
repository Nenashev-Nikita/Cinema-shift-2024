package com.example.cinema.design.resources.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

object CinemaTheme {
	val colors: CinemaColors
		@Composable
		get() = LocalCinemaColors.current
	val typography: CinemaTypography
		@Composable
		get() = LocalCinemaTypography.current
	val elevation: CinemaElevation
		@Composable
		get() = LocalCinemaElevation.current
	val shapes: CinemaShapes
		@Composable
		get() = LocalCinemaShapes.current
	val padding: CinemaPadding
		@Composable
		get() = LocalCinemaPadding.current
}

@Composable
fun CinemaTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	val colorScheme = if (darkTheme) DarkColors else LightColors

	CompositionLocalProvider(
		LocalCinemaColors provides colorScheme,
		LocalCinemaTypography provides cinemaTypography,
		LocalCinemaElevation provides cinemaElevation,
		LocalCinemaShapes provides cinemaShapes,
		LocalCinemaPadding provides cinemaPadding,
		content = content
	)
}