package com.example.cinema.feature.history.presentation

import com.example.cinema.component.arch.BaseViewModel
import com.example.cinema.shared.loan.domain.usecase.GetLoanHistoryItemsUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
	private val getLoanHistoryItemsUseCase: GetLoanHistoryItemsUseCase,
) : BaseViewModel() {

	private val _state = MutableStateFlow<HistoryState>(HistoryState.Initial)
	val state: StateFlow<HistoryState> = _state

	fun loadLoans() {
		launch {
			_state.value = HistoryState.Loading

			try {
				val loans = getLoanHistoryItemsUseCase()
				_state.value = HistoryState.Content(loans)
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = HistoryState.Failure(ex.localizedMessage.orEmpty())
			}
		}
	}
}