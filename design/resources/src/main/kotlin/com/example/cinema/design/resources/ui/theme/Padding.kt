package com.example.cinema.design.resources.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class CinemaPadding(
	val extraSmall: Dp,
	val small: Dp,
	val medium: Dp,
	val large: Dp,
)

val LocalCinemaPadding = staticCompositionLocalOf {
	CinemaPadding(
		extraSmall = Dp.Unspecified,
		small = Dp.Unspecified,
		medium = Dp.Unspecified,
		large = Dp.Unspecified,
	)
}

val cinemaPadding = CinemaPadding(
	extraSmall = 4.dp,
	small = 8.dp,
	medium = 16.dp,
	large = 24.dp,
)