package com.example.cinema.shared.loan.domain.entity

data class LoanHistoryItem(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
)