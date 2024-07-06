package com.example.cinema.di.modules

import com.example.cinema.component.network.createRetrofitService
import com.example.cinema.shared.loan.data.network.LoanApi
import com.example.cinema.shared.loan.data.repository.LoanRepositoryImpl
import com.example.cinema.shared.loan.domain.repository.LoanRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface LoadModule {

	companion object {

		@Provides
		fun provideLoadApi(retrofit: Retrofit): LoanApi = createRetrofitService(retrofit)
	}

	@Binds
	fun bindLoadRepository(
		loanRepositoryImpl: LoanRepositoryImpl
	): LoanRepository
}