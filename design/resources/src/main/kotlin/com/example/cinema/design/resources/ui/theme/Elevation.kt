package com.example.cinema.design.resources.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class CinemaElevation(
	val default: Dp,
	val pressed: Dp
)

val LocalCinemaElevation = staticCompositionLocalOf {
	CinemaElevation(
		default = Dp.Unspecified,
		pressed = Dp.Unspecified
	)
}

val cinemaElevation = CinemaElevation(
	default = 4.dp,
	pressed = 8.dp
)