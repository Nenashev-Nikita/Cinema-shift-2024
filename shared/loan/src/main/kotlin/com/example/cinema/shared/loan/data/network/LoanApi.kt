package com.example.cinema.shared.loan.data.network

import com.example.cinema.shared.loan.data.model.LoanHistoryItemModel
import com.example.cinema.shared.loan.data.model.LoanModel
import retrofit2.http.GET
import retrofit2.http.Path

interface LoanApi {

	@GET("loans")
	suspend fun getAll(): List<LoanHistoryItemModel>

	@GET("loans/{loanId}")
	suspend fun get(@Path("loanId") loanId: Long): LoanModel
}