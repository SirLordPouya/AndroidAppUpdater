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

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
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
    implementation(libs.appcompat)
    implementation(libs.constraintLayout)

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
    androidTestImplementation(libs.androidTestJUnit)
    androidTestImplementation(libs.androidTestRules)
    androidTestImplementation(libs.androidTestEspresso)
    androidTestImplementation(composeBom)
}
