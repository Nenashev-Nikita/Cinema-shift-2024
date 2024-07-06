package com.example.cinema.shared.loan.data.converter

import com.example.cinema.shared.loan.data.model.LoanModel
import com.example.cinema.shared.loan.domain.entity.Loan
import javax.inject.Inject

class LoanConverter @Inject constructor() {

	fun convert(model: LoanModel): Loan =
		Loan(
			id = model.id,
			firstName = model.firstName,
			lastName = model.lastName,
			amount = model.amount,
			percent = model.percent,
			status = model.status,
			phone = model.phone,
			issueDate = model.issueDate,
			monthPeriod = model.monthPeriod,
		)
}