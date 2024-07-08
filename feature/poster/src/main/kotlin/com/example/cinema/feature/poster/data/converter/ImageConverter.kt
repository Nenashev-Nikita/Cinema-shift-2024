package com.example.cinema.feature.poster.data.converter

import android.graphics.drawable.Drawable
import java.io.InputStream
import java.net.URL
import javax.inject.Inject

class ImageConverter @Inject constructor() {

	operator fun invoke(url: String?): Drawable? {
		try {
			val `is` = URL(url).content as InputStream
			val d = Drawable.createFromStream(`is`, "src name")
			return d
		} catch (e: Exception) {
			return null
		}
	}
}