package codes.romain.kotlinx.bootstrap.demo

import codes.romain.bootstrap.icons.BootstrapIcon
import codes.romain.bootstrap.kotlinx.html.AlertType
import codes.romain.bootstrap.kotlinx.html.TextStyle
import codes.romain.bootstrap.kotlinx.html.alert
import codes.romain.bootstrap.kotlinx.html.alertHeading
import codes.romain.bootstrap.kotlinx.html.alertLink
import codes.romain.bootstrap.kotlinx.html.badge
import codes.romain.bootstrap.kotlinx.html.icon
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.h4
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.style
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.absolute
import kotlin.io.path.createDirectories
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteRecursively

@OptIn(ExperimentalPathApi::class)
fun main(args: Array<String>) {
    val index = Page("Kotlinx HTML Bootstrap Demo") {
        h1("text-center") { +"Kotlinx HTML Demo" }
        div("links text-center mb-3 d-flex") {
            style = "justify-content:center; column-gap: 10px;"

            a("https://github.com/Palleas/kotlin-bootstrap") {
                icon(BootstrapIcon.Github) { classes += "me-1"}
                +"GitHub Repository"
            }

            a("https://getbootstrap.com/") {
                icon(BootstrapIcon.BootstrapFill) { classes += "me-1"}
                +"Bootstrap"
            }
        }

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

        section {
            h2 { +"Badges" }

            p {
                a(href = "https://getbootstrap.com/docs/5.3/components/badges") {
                    icon(BootstrapIcon.Bootstrap) { classes += "me-2" }
                    +"View on Bootstrap"
                }
            }


            div("d-flex") {
                style = "column-gap: 10px;"

                TextStyle.entries.forEach {
                    badge(it) { +"Badge" }
                }

            }
        }
    }.render()

    val targetDirectory = Path(args.first())
    runCatching { targetDirectory.createDirectories() }

    println("Generating demo to $targetDirectory")

    val indexPath = targetDirectory.resolve("index.html")
    Files.write(indexPath, index.toByteArray())
}