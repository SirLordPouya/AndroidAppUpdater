plugins {
    id("com.android.library")
    id("kotlin-android")
    `maven-publish`
}

android {
    compileSdk = libs.versions.compileSdkVersion.get().toInt()
    defaultConfig {
        minSdk = libs.versions.composeMinSdkVersion.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
    namespace = "com.pouyaheydari.appupdater.compose"

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
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api(project(":core"))

    // compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.viewModel)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // testing
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidTestJUnit)
    androidTestImplementation(libs.androidTestEspresso)
    androidTestImplementation(composeBom)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.pouyaheydari.updater"
                artifactId = "compose"
                version = libs.versions.appVersion.get()
            }
        }
    }
}
