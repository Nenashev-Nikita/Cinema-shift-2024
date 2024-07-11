package com.example.cinema.feature.film.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.cinema.design.resources.ui.theme.CinemaTheme
import com.example.cinema.feature.film.R

private const val MIN_LINES = 6
private const val SPACE = " "

//TODO разбить на функции
@Composable
fun DescriptionFilm(
	description: String,
	modifier: Modifier = Modifier,
	textModifier: Modifier = Modifier,
) {
	var isExpanded by remember { mutableStateOf(false) }
	var clickable by remember { mutableStateOf(false) }
	var lastCharIndex by remember { mutableIntStateOf(0) }

	Box(modifier = Modifier
		.clickable(clickable) {
			isExpanded = !isExpanded
		}
		.then(modifier)
	) {
		Text(
			modifier = textModifier
				.fillMaxWidth()
				.animateContentSize(),
			text = buildAnnotatedString {
				if (clickable) {
					if (isExpanded) {
						append(description)
						withStyle(
							style = SpanStyle(
								fontSize = 16.sp,
								color = CinemaTheme.colors.textQuartenery,
							)
						) { append(stringResource(id = R.string.collapse_text)) }
					} else {
						val adjustText = description.substring(startIndex = 0, endIndex = lastCharIndex)
							.dropLast(stringResource(id = R.string.expand_text).length)
							.dropLastWhile { Character.isWhitespace(it) || it == '.' }
						append(adjustText)
						withStyle(
							style = SpanStyle(
								fontSize = 16.sp,
								color = CinemaTheme.colors.textQuartenery,
							)
						) { append(stringResource(id = R.string.expand_text)) }
					}
				} else {
					append(description)
				}
			},
			maxLines = if (isExpanded) Int.MAX_VALUE else MIN_LINES,
			onTextLayout = { textLayoutResult ->
				if (!isExpanded && textLayoutResult.hasVisualOverflow) {
					clickable = true
					lastCharIndex = textLayoutResult.getLineEnd(MIN_LINES - 1)
				}
			},
			style = CinemaTheme.typography.paragraph.copy(
				fontSize = 16.sp,
				color = CinemaTheme.colors.textPrimary,
			),
		)
	}
}