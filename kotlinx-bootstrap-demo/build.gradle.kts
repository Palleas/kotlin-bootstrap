plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.html)
    implementation(project(":bootstrap-icons"))
    implementation(project(":kotlinx-html-bootstrap"))
    implementation(project(":components"))

    testImplementation(libs.kotest.runner)
}

tasks.register<JavaExec>("generate") {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = "codes.romain.kotlinx.bootstrap.demo.EntrypointKt"
    args = listOf(rootDir.resolve("demo-build").absolutePath)
}