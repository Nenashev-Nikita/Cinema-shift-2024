plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.jetbrains.kotlin.serialization)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.cinema.shared.loan"
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
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.14"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(project(":util:formatting"))
	implementation(project(":component:network"))

	implementation(libs.dagger.compiler)
	implementation(libs.dagger)
	ksp(libs.dagger.compiler)

	// Работа с сетью
	implementation(libs.retrofit.core)
	implementation(libs.retrofit.converter.kotlinxserialization)
	implementation(libs.okhttp.logginginterceptor)

	// Сериализация JSON
	implementation(libs.kotlinx.serialization.json)

	implementation(libs.androidx.ui.android)

	// Unit-тестирование
	testImplementation(libs.junit)
}