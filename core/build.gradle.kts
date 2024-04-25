plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
    `maven-publish`
}

java {
    withJavadocJar()
    withSourcesJar()
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["java"])
                groupId = "com.pouyaheydari.updater"
                artifactId = "core"
                version = libs.versions.appVersion.get()
            }
        }
    }
}
