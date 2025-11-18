import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt") // 👈 Necesario para Hilt y Room
    id("dagger.hilt.android.plugin") // 👈 esto es indispensable
    id ("com.google.gms.google-services")  // <<<<< Asegúrate de esto
}



android {
    namespace = "com.example.actividad5_tema3_carloscaramecerero"
    compileSdk = 36

            defaultConfig {
            applicationId = "com.example.actividad5_tema3_carloscaramecerero"
            minSdk = 21
            targetSdk = 34
            versionCode = 1
            versionName = "1.0"
        }


buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

        packaging {
            resources {
                excludes += setOf(
                    "META-INF/INDEX.LIST",
                    "META-INF/DEPENDENCIES",
                    "META-INF/io.netty.versions.properties"
                )
            }
        }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.firebase.appdistribution.gradle)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ------------------------------------
    // Dependencias nuevas para tu proyecto
    // Firebase Auth
    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    implementation("com.google.firebase:firebase-auth-ktx")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1") // Or a newer stable version
    kapt("com.google.dagger:hilt-android-compiler:2.51.1") // Or a newer stable version

    // Hilt + Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Update for compatibility

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle - ViewModel y LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
// Compose integration
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    implementation("androidx.room:room-runtime:2.7.2")
    kapt("androidx.room:room-compiler:2.7.2")
// In app/build.gradle.kts



}
}
