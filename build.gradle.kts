plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

group = "codes.romain"

tasks.withType<PublishToMavenRepository>().configureEach {
    doFirst {
        val envVersion = System.getenv("VERSION")
        if (envVersion.isNullOrBlank()) {
            error("VERSION environment variable must be set when publishing.")
        } else {
            project.version = envVersion
        }
    }
}