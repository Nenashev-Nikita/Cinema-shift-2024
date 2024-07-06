plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.cinema.component.token"
	compileSdk = 34

	defaultConfig {
		minSdk = 26

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.dagger.compiler)
	implementation(libs.dagger)
	ksp(libs.dagger.compiler)

	implementation(libs.retrofit.moshi.kotlin)

	implementation(libs.kotlinx.coroutines.android)

	implementation(libs.retrofit.core)
	implementation(libs.retrofit.converter.kotlinxserialization)
	implementation(libs.okhttp.logginginterceptor)

	implementation(libs.kotlinx.serialization.json)

	// Unit-тестирование
	testImplementation(libs.junit)
}