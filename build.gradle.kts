plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }

    group = "codes.romain"
}
