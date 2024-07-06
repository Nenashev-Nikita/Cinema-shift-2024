package com.example.cinema.shared.loan.domain.entity

import java.time.LocalDateTime

data class Loan(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
	val phone: String,
	val issueDate: LocalDateTime,
	val monthPeriod: Int,
)