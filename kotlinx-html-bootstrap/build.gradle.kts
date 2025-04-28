plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.html)
    api(project(":bootstrap-icons"))
    testImplementation(libs.kotest.runner)
}

publishing {
    publications {
        register<MavenPublication>("reposilite") {
            from(components["java"])
        }
    }

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
