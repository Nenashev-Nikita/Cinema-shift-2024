package com.example.cinema.component.network.provider

import com.squareup.moshi.Moshi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

fun provideRetrofit(
	okHttpClient: OkHttpClient,
	moshi: Moshi,
	url: String
): Retrofit = Retrofit.Builder()
	.addConverterFactory(ScalarsConverterFactory.create())
	.addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
	.client(okHttpClient)
	.baseUrl(url)
	.build()
