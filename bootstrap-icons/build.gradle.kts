plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm)
}

publishing {
    publications {
        register<MavenPublication>("reposilite") {
            from(components["java"])
        }
    }
}
