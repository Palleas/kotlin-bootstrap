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
    repositories {
        maven {
            name = "reposiliteRepository"
            url = uri("https://reposilite.dokku.perfectly-cooked.com/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }

    publications {
        register<MavenPublication>("reposilite") {
            from(components["java"])
        }
    }
}