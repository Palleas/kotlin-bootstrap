plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm)
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
