package com.example.cinema.design.resources.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val lightPrimary = Color(0xFFFFFFFF)
val lightTextPrimary = Color(0xFF141C24)
val lightSecondary = Color(0xFFF5F5F8)
val lightTextTertiary = Color(0xFF637083)
val lightIndicator = Color(0xFFFFB219)
val lightBrand = Color(0xFF9534D2)
val lightTextInvert = Color(0xFFFFFFFF)

val darkPrimary = Color(0xFFFFFFFF)
val darkTextPrimary = Color(0xFF141C24)
val darkSecondary = Color(0xFFF5F5F8)
val darkTextTertiary = Color(0xFF637083)
val darkIndicator = Color(0xFFFFB219)
val darkBrand = Color(0xFF9534D2)
val darkTextInvert = Color(0xFFFFFFFF)

@Immutable
data class CinemaColors(
	val primary: Color,
	val textPrimary: Color,
	val secondary: Color,
	val textTertiary: Color,
	val indecator: Color,
	val brand: Color,
	val textInvert: Color,
)

val LocalCinemaColors = staticCompositionLocalOf {
	CinemaColors(
		primary = Color.Unspecified,
		textPrimary = Color.Unspecified,
		secondary = Color.Unspecified,
		textTertiary = Color.Unspecified,
		indecator = Color.Unspecified,
		brand = Color.Unspecified,
		textInvert = Color.Unspecified,
	)
}

val LightColors = CinemaColors(
	primary = lightPrimary,
	textPrimary = lightTextPrimary,
	secondary = lightSecondary,
	textTertiary = lightTextTertiary,
	indecator = lightIndicator,
	brand = lightBrand,
	textInvert = lightTextInvert,
)

val DarkColors = CinemaColors(
	primary = darkPrimary,
	textPrimary = darkTextPrimary,
	secondary = darkSecondary,
	textTertiary = darkTextTertiary,
	indecator = darkIndicator,
	brand = darkBrand,
	textInvert = darkTextInvert,
)
