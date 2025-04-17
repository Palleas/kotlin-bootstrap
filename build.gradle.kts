plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }

    version = "1.0-SNAPSHOT"
    group = "codes.romain"
}


