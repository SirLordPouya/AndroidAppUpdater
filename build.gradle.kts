buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.agp)
        classpath(libs.kotlin.gradle.plugin)
    }
}

allprojects {
    repositories {
        maven("https://maven.google.com")
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
