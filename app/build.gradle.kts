import java.util.Properties

val localProps = Properties()
localProps.load(rootProject.file("local.properties").inputStream())

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.pedrodev.lyriclearn"
    compileSdk = 36
    buildToolsVersion = "36.1.0"

    defaultConfig {
        applicationId = "com.pedrodev.lyriclearn"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "YOUTUBE_API_KEY",
            "\"${localProps.getProperty("YOUTUBE_API_KEY")}\""
        )

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    //retrofit to HTTP requests
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // Convert JSON
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // logging interceptor to modify request and add api key
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //coil to Async images by url
    implementation("io.coil-kt:coil-compose:2.4.0")

    //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    //Hilt, dependency incejtor framework(DI)
    implementation("com.google.dagger:hilt-android:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    ksp("com.google.dagger:hilt-compiler:2.51.1")

    //navigation, to change screens
    implementation("androidx.navigation:navigation-compose:2.9.6")

    //youtube player
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:13.0.0")

    //Rooms to local database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    ksp("androidx.room:room-compiler:2.6.1")

    //Animated navigation
    implementation("com.google.accompanist:accompanist-navigation-animation:0.34.0")

}