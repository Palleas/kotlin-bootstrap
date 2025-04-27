plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.html)
    implementation(project(":bootstrap-icons"))
    testImplementation(libs.kotest.runner)
}

publishing {
    publications {
        register<MavenPublication>("reposilite") {
            from(components["java"])
        }
    }
}