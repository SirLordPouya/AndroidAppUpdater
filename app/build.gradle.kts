plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = libs.versions.compileSdkVersion.get().toInt()
    defaultConfig {
        applicationId = "com.pouyaheydari.androidappupdater"
        minSdk = libs.versions.composeMinSdkVersion.get().toInt()
        targetSdk = libs.versions.targetSdkVersion.get().toInt()
        versionCode = libs.versions.appVersion.get().toInt()
        versionName = libs.versions.appVersion.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    namespace = "com.pouyaheydari.androidappupdater"

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
        kotlinCompilerExtensionVersion = libs.versions.composeCompilerExtension.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // library dependency
    implementation(project(":appupdater"))
    implementation(project(":compose"))

    // support dependency
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintLayout)

    // compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.material)

    // testing dependency
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.ui.espresso.core)
    androidTestImplementation(composeBom)
}
