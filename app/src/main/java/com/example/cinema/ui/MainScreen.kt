package com.example.cinema.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinema.feature.history.HistoryRoute
import com.example.cinema.feature.history.ui.HistoryScreen

@Composable
fun MainScreen() {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = HistoryRoute) {
			composable<HistoryRoute> {
				HistoryScreen(
					onItemSelected = { },
				)
			}
		}
	}
}