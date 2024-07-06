plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.jetbrains.kotlin.serialization)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.cinema.util.di"
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

	implementation(libs.dagger.compiler)
	implementation(libs.dagger)
	ksp(libs.dagger.compiler)

	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.ui.android)

	// Unit-тестирование
	testImplementation(libs.junit)
}