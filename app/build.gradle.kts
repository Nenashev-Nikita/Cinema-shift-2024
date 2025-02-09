plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.google.ksp)
}

android {
	namespace = "com.example.cinema"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.cinema"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
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

	implementation(project(":component:arch"))
	implementation(project(":component:token"))
	implementation(project(":component:network"))
	implementation(project(":design:resources"))

	implementation(project(":feature:poster"))

	implementation(libs.dagger.compiler)
	implementation(libs.dagger)
	ksp(libs.dagger.compiler)

	implementation(libs.retrofit.moshi)
	implementation(libs.retrofit.moshi.kotlin)
	implementation(libs.retrofit.moshi.adapters)
	implementation(libs.retrofit.converter.moshi)
	implementation(libs.retrofit.converter.scalars)

	// Compose
	implementation(libs.androidx.material3)

	// Навигация с Compose
	implementation(libs.androidx.navigation.compose)

	// Unit-тестирование
	testImplementation(libs.junit)
	implementation(libs.kotlinx.coroutines.test)

	// UI-тестирование
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
}