package com.example.cinema.shared.loan.data.repository

import com.example.cinema.shared.loan.data.converter.LoanConverter
import com.example.cinema.shared.loan.data.converter.LoanHistoryItemConverter
import com.example.cinema.shared.loan.data.network.LoanApi
import com.example.cinema.shared.loan.domain.entity.Loan
import com.example.cinema.shared.loan.domain.entity.LoanHistoryItem
import com.example.cinema.shared.loan.domain.repository.LoanRepository
import javax.inject.Inject

class LoanRepositoryImpl @Inject constructor(
	private val loanConverter: LoanConverter,
	private val loanHistoryItemConverter: LoanHistoryItemConverter,
	private val loanApi: LoanApi,
) : LoanRepository {

	override suspend fun getAll(): List<LoanHistoryItem> {
		val models = loanApi.getAll()
		return models.map { loanHistoryItemConverter.convert(it) }
	}

	override suspend fun get(loanId: Long): Loan {
		val model = loanApi.get(loanId)
		return loanConverter.convert(model)
	}
}