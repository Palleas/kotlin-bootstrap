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

publishing {
    repositories {
        maven {
            name = "releases"

            url = uri("https://reposilite.dokku.perfectly-cooked.com/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }

        maven {
            name = "snapshots"

            url = uri("https://reposilite.dokku.perfectly-cooked.com/snapshots")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}