val compose_version: String by rootProject.extra

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
}

dependencies {

    implementation(project(":lib"))
    implementation(project(":core:core-ui"))

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material3:material3:1.0.0-alpha13")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.navigation:navigation-compose:2.5.0-rc02")

    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")
    debugImplementation("androidx.customview:customview:1.2.0-alpha01")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0-rc01")
}