package com.example.cinema.shared.loan.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cinema.shared.loan.R
import com.example.cinema.shared.loan.domain.entity.LoanStatus
import java.text.NumberFormat
import java.util.Locale

@Composable
fun formatAmountText(amount: Long): String {
	val numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault())
	return numberFormatter.format(amount) + stringResource(R.string.ruble)
}

@Composable
fun formatLoanStatus(status: LoanStatus): String =
	when (status) {
		LoanStatus.APPROVED   -> stringResource(R.string.approved)
		LoanStatus.REGISTERED -> stringResource(R.string.registered)
		LoanStatus.REJECTED   -> stringResource(R.string.rejected)
	}