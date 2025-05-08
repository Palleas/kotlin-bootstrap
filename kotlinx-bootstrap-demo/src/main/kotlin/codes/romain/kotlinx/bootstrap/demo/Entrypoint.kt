package codes.romain.kotlinx.bootstrap.demo

import codes.romain.bootstrap.icons.BootstrapIcon
import codes.romain.bootstrap.kotlinx.html.AlertType
import codes.romain.bootstrap.kotlinx.html.alert
import codes.romain.bootstrap.kotlinx.html.alertHeading
import codes.romain.bootstrap.kotlinx.html.alertLink
import codes.romain.bootstrap.kotlinx.html.icon
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.h4
import kotlinx.html.p
import kotlinx.html.section
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteRecursively

@OptIn(ExperimentalPathApi::class)
fun main(args: Array<String>) {
    val index = Page("Kotlinx HTML Bootstrap Demo") {
        h1("text-center") { +"Kotlinx HTML Demo" }

        section {
            h2("mb-0") {
                +"Alerts"
            }

            p {
                a(href = "https://getbootstrap.com/docs/5.3/components/alerts") {
                    icon(BootstrapIcon.Bootstrap) { classes += "me-2" }
                    +"View on Bootstrap"
                }
            }

            AlertType.entries.forEach {
                alert(it) {
                    h4 {
                        alertHeading()
                        +"Alert Title"
                    }
                    p {
                        +"This is an alert"
                    }

                    p("m-0") {
                        a("/") {
                            alertLink()
                            +"Here is a link"
                        }
                    }

                }
            }

        }
    }.render()

    val targetDirectory = Path(".").resolve("demo-build")
    targetDirectory.deleteRecursively()
    targetDirectory.createDirectory()

    val indexPath = targetDirectory.resolve("index.html")
    Files.write(indexPath, index.toByteArray())

    val css = object {}.javaClass.classLoader.getResource("bootstrap.min.css")!!
    Files.copy(java.nio.file.Path.of(css.toURI()), targetDirectory.resolve("bootstrap.min.css"))
}