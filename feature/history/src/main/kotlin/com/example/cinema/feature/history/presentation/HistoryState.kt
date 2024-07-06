package com.example.cinema.feature.history.presentation

import com.example.cinema.shared.loan.domain.entity.LoanHistoryItem

sealed interface HistoryState {

	data object Initial : HistoryState
	data object Loading : HistoryState
	data class Failure(val message: String?) : HistoryState
	data class Content(val loans: List<LoanHistoryItem>) : HistoryState
}