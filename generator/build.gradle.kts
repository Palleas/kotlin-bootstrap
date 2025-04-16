plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlin.poet)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.dataset)
}

repositories {
    mavenCentral()
}

