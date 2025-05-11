plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"

}

rootProject.name = "kotlin-bootstrap"

include(":bootstrap-icons")

include(":generator")
include(":kotlinx-html-bootstrap")
include(":kotlinx-bootstrap-demo")
include("components")
