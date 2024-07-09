package com.example.cinema.component.network.interceptor

import com.example.cinema.component.network.token.domain.usecase.GetTokenUseCase
import com.example.cinema.component.network.token.domain.usecase.IsTokenExistUseCase
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

 class TokenInterceptor @Inject constructor(
	 private val getTokenUseCase: GetTokenUseCase,
	 private val isTokenExistUseCase: IsTokenExistUseCase
) : Interceptor {

	internal companion object {

		const val TOKEN_HEADER = "Authorization"
	}

	override fun intercept(chain: Interceptor.Chain): Response {
		if (isTokenExistUseCase()) {
			val requestBuilder: Request.Builder = chain.request().newBuilder()
				.addHeader(TOKEN_HEADER, getTokenUseCase())
			val request: Request = requestBuilder.build()

			return chain.proceed(request)
		}

		return chain.proceed(chain.request())
	}
}