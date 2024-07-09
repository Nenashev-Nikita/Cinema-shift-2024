package com.example.cinema.design.resources.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class CinemaShapes(
	val small: Dp,
	val medium: Dp,
)

val LocalCinemaShapes = staticCompositionLocalOf {
	CinemaShapes(
		small = Dp.Unspecified,
		medium = Dp.Unspecified,
	)
}

val cinemaShapes = CinemaShapes(
	small = 4.dp,
	medium = 8.dp,
)