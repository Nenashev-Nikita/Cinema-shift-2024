package com.example.cinema.feature.history.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinema.feature.history.di.HistoryRoot
import com.example.cinema.util.di.findActivity
import com.example.cinema.feature.history.R
import com.example.cinema.feature.history.di.HistoryComponentViewModel
import com.example.cinema.feature.history.presentation.HistoryState
import com.example.cinema.feature.history.presentation.HistoryViewModel

@Composable
fun HistoryScreen(
	onItemSelected: (loanId: Long) -> Unit,
) {
	val context = LocalContext.current
	val component = (context.findActivity().application as? HistoryRoot)?.historyComponentBuilder?.build()

	val componentViewModel: HistoryComponentViewModel = viewModel()

	component?.inject(componentViewModel)

	val historyViewModel: HistoryViewModel = viewModel(factory = componentViewModel.viewModelFactory)
	val historyState by historyViewModel.state.collectAsState()

	LaunchedEffect(Unit) {
		historyViewModel.loadLoans()
	}

	Column(modifier = Modifier.fillMaxSize()) {
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 12.dp, horizontal = 8.dp),
			text = stringResource(id = R.string.history_title),
			style = MaterialTheme.typography.titleLarge,
		)

		when (val state = historyState) {
			is HistoryState.Initial,
			is HistoryState.Loading -> LoadingComponent()

			is HistoryState.Failure -> ErrorComponent(
				message = state.message ?: stringResource(id = R.string.error_unknown_error),
				onRetry = { historyViewModel.loadLoans() },
			)

			is HistoryState.Content -> ContentComponent(
				loans = state.loans,
				onItemClicked = onItemSelected,
			)
		}
	}
}