package com.example.cinema.shared.loan.domain.usecase

import com.example.cinema.shared.loan.domain.entity.LoanHistoryItem
import com.example.cinema.shared.loan.domain.repository.LoanRepository
import javax.inject.Inject

class GetLoanHistoryItemsUseCase @Inject constructor(private val repository: LoanRepository) {

	suspend operator fun invoke(): List<LoanHistoryItem> =
		repository.getAll()
}