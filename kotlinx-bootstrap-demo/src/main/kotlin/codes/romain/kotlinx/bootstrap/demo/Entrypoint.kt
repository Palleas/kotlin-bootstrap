package codes.romain.kotlinx.bootstrap.demo

import codes.romain.bootstrap.icons.BootstrapIcon
import codes.romain.bootstrap.kotlinx.html.AlertType
import codes.romain.bootstrap.kotlinx.html.TextStyle
import codes.romain.bootstrap.kotlinx.html.alert
import codes.romain.bootstrap.kotlinx.html.alertHeading
import codes.romain.bootstrap.kotlinx.html.alertLink
import codes.romain.bootstrap.kotlinx.html.badge
import codes.romain.bootstrap.kotlinx.html.icon
import codes.romain.kotlinx.bootstrap.demo.components.alerts
import codes.romain.kotlinx.bootstrap.demo.components.badges
import codes.romain.kotlinx.bootstrap.demo.components.tableViews
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.code
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.h4
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.section
import kotlinx.html.style
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.absolute
import kotlin.io.path.createDirectories
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteRecursively


fun main(args: Array<String>) {
    val index = Page("Kotlinx HTML Bootstrap Demo") {
        h1("text-center") { +"Kotlinx HTML Demo" }
        div("links text-center mb-3 d-flex") {
            style = "justify-content:center; column-gap: 10px;"

            a("https://github.com/Palleas/kotlin-bootstrap") {
                icon(BootstrapIcon.Github) { classes += "me-1" }
                +"GitHub Repository"
            }

            a("https://getbootstrap.com/") {
                icon(BootstrapIcon.BootstrapFill) { classes += "me-1" }
                +"Bootstrap"
            }
        }

        h2("text-center") { +"kotlinx-html-bootstrap" }

        alerts()

        badges()

        h2("text-center") { +"components" }

        tableViews()
    }.render()

    val targetDirectory = Path(args.first())
    runCatching { targetDirectory.createDirectories() }

    println("Generating demo to $targetDirectory")

    val indexPath = targetDirectory.resolve("index.html")
    Files.write(indexPath, index.toByteArray())
}