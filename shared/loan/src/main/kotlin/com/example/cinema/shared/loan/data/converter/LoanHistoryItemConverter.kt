package com.example.cinema.shared.loan.data.converter

import com.example.cinema.shared.loan.data.model.LoanHistoryItemModel
import com.example.cinema.shared.loan.domain.entity.LoanHistoryItem
import javax.inject.Inject

class LoanHistoryItemConverter @Inject constructor() {

	fun convert(model: LoanHistoryItemModel): LoanHistoryItem =
		LoanHistoryItem(
			id = model.id,
			firstName = model.firstName,
			lastName = model.lastName,
			amount = model.amount,
			percent = model.percent,
			status = model.status,
		)
}