package com.example.cinema.shared.loan.data.model

import com.example.cinema.shared.loan.data.converter.LocalDateTimeSerializer
import com.example.cinema.shared.loan.domain.entity.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class LoanModel(
	val id: Long,
	@SerialName("first_name")
	val firstName: String,
	@SerialName("last_name")
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
	val phone: String,
	@SerialName("date")
	@Serializable(LocalDateTimeSerializer::class)
	val issueDate: LocalDateTime,
	@SerialName("period")
	val monthPeriod: Int,
)