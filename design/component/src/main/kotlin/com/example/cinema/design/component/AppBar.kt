package com.example.cinema.design.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.cinema.design.compose.R
import com.example.cinema.design.resources.ui.theme.CinemaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
	title: String? = null,
	leftIcon: ImageVector? = null,
	onLeftButtonClick: (() -> Unit)? = null,
) {
	key(MaterialTheme.colorScheme.background) {
		TopAppBar(
			title = {
				Text(
					text = title ?: "",
					style = CinemaTheme.typography.titleLarge
				)
			},
			modifier = Modifier.fillMaxWidth(),
			colors = TopAppBarDefaults.topAppBarColors(
				containerColor = CinemaTheme.colors.primary,
				titleContentColor = CinemaTheme.colors.textPrimary,
				navigationIconContentColor = CinemaTheme.colors.indecator,
			),
			navigationIcon = {
				leftIcon.let { icon ->
					IconButton(
						onClick = { onLeftButtonClick?.invoke() },
					) {
						Icon(
							imageVector = icon ?: ImageVector.vectorResource(id = R.drawable.ic_left),
							contentDescription = null,
							modifier = Modifier.size(24.dp)
						)
					}
				}
			},
		)
	}
}
