package com.example.cinema.design.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema.design.resources.ui.theme.CinemaTheme

@Composable
fun Button(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	containerColor: Color = CinemaTheme.colors.brand,
	enabled: Boolean = true,
) {
	val colors = ButtonDefaults.buttonColors(
		containerColor = containerColor,
	)

	Button(
		onClick = onClick,
		modifier = modifier
			.fillMaxWidth()
			.height(56.dp),
		enabled = enabled,
		shape = MaterialTheme.shapes.medium,
		colors = colors,
	) {
		Text(
			text = text,
			color = CinemaTheme.colors.textInvert,
			style = CinemaTheme.typography.titleMedium.copy(fontSize = 16.sp)
		)
	}
}