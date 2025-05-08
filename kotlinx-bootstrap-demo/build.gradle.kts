plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.html)
    implementation(project(":bootstrap-icons"))
    implementation(project(":kotlinx-html-bootstrap"))

    testImplementation(libs.kotest.runner)
}