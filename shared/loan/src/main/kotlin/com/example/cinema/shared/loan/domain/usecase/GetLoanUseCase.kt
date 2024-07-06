package com.example.cinema.shared.loan.domain.usecase

import com.example.cinema.shared.loan.domain.entity.Loan
import com.example.cinema.shared.loan.domain.repository.LoanRepository
import javax.inject.Inject

class GetLoanUseCase @Inject constructor(private val loanRepository: LoanRepository) {

	suspend operator fun invoke(loanId: Long): Loan =
		loanRepository.get(loanId)
}