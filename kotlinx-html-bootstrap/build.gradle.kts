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
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/palleas/kotlin-bootstrap")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }

    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}