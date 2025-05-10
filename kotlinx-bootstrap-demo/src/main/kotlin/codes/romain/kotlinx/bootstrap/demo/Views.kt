package codes.romain.kotlinx.bootstrap.demo

import codes.romain.bootstrap.icons.BootstrapIcon
import codes.romain.bootstrap.kotlinx.html.icon
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.code
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.section

fun FlowContent.componentSection(title: String, url: String, rawCode: String, content: DIV.() -> Unit) {
    section("border-bottom mb-4 pb-2") {
        h2("mb-0") {
            a("#demo-${title.lowercase()}", classes = "text-decoration-none text-reset") {
                attributes["data-bs-toggle"] = "collapse"
                +title
            }
        }
        div("collapse") {
            id = "demo-${title.lowercase()}"
            p {
                a(href = url) {
                    icon(BootstrapIcon.Bootstrap) { classes += "me-2" }
                    +"View on Bootstrap"
                }
            }

            p { +"The following code:" }

            pre {
                code("language-kotlin") {
                    +rawCode.trimIndent()
                }
            }

            p { +"Will render:" }

            div {
                content()
            }
        }
    }
}
