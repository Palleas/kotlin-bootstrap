plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(libs.kotlin.poet)
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.dataset)
}

repositories {
    mavenCentral()
}

