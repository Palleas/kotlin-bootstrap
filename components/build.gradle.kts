plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(project(":bootstrap-icons"))
    implementation(project(":kotlinx-html-bootstrap"))
    implementation(libs.kotlinx.html)

    testImplementation(libs.kotest.runner)
    testImplementation(libs.selfie.kotest)
}

tasks.test {
    useJUnitPlatform()
}