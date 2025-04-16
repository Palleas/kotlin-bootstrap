plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"

}

rootProject.name = "kotlin-bootstrap"

include(":bootstrap-icons")
//findProject(":bootstrap-icons")!!.name = "kotlin-bootstrap-icons"

include(":generator")
