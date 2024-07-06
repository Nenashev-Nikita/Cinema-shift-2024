package com.example.cinema.shared.loan.domain.repository

import com.example.cinema.shared.loan.domain.entity.Loan
import com.example.cinema.shared.loan.domain.entity.LoanHistoryItem

interface LoanRepository {

	suspend fun getAll(): List<LoanHistoryItem>

	suspend fun get(loanId: Long): Loan
}