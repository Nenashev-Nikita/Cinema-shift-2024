package com.example.cinema.di.modules

import com.example.cinema.component.network.interceptor.LoggingInterceptor
import com.example.cinema.component.network.interceptor.TokenInterceptor
import com.example.cinema.component.network.provider.provideOkHttpClient
import com.example.cinema.component.network.provider.provideRetrofit
import com.example.cinema.component.network.token.di.TokenModule
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.Date
import javax.inject.Singleton

@Module(includes = [TokenModule::class])
object NetworkModule {

	private const val BASE_URL = "https://shift-backend.onrender.com/android/"

	@Provides
	fun providerOkHttpClient(
		tokenInterceptor: TokenInterceptor,
		loggingInterceptor: LoggingInterceptor,
	): OkHttpClient = provideOkHttpClient(
		interceptors = listOf(tokenInterceptor, loggingInterceptor)
	)

	@Provides
	fun providerMoshi(): Moshi = Moshi.Builder()
		.add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
		.add(KotlinJsonAdapterFactory())
		.build()

	@Provides
	fun providerRetrofit(
		okHttpClient: OkHttpClient,
		moshi: Moshi,
	): Retrofit = provideRetrofit(
		okHttpClient = okHttpClient,
		moshi = moshi,
		url = BASE_URL,
	)
}