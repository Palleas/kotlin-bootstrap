package codes.romain.kotlinx.bootstrap.demo

import codes.romain.bootstrap.icons.BootstrapIcon
import codes.romain.bootstrap.kotlinx.html.icon
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.code
import kotlinx.html.div
import kotlinx.html.h3
import kotlinx.html.id
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.section

private fun generateId(string: String) = "demo-" + string.lowercase().replace("\\W+".toRegex(), "-")

fun FlowContent.componentSection(title: String, url: String?, rawCode: String, content: DIV.() -> Unit) {
    val componentId = generateId(title)
    section("border-bottom mb-4 pb-2") {
        h3("mb-0") {
            a("#$componentId", classes = "text-decoration-none text-reset") {
                attributes["data-bs-toggle"] = "collapse"
                +title
            }
        }
        div("collapse") {
            id = componentId

            if (url != null) {
                p {
                    a(href = url) {
                        icon(BootstrapIcon.Bootstrap) { classes += "me-2" }
                        +"View on Bootstrap"
                    }
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
