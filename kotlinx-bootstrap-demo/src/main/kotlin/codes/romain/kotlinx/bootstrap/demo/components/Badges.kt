package codes.romain.kotlinx.bootstrap.demo.components

import codes.romain.bootstrap.kotlinx.html.TextStyle
import codes.romain.bootstrap.kotlinx.html.badge
import codes.romain.kotlinx.bootstrap.demo.componentSection
import kotlinx.html.FlowContent

fun FlowContent.badges() {
    componentSection(
        "Badges",
        url = "https://getbootstrap.com/docs/5.3/components/badges",
        rawCode = """
            badge(TextStyle.Success) { +"Build 1.2.2-Beta" }
        """.trimIndent()
    ) {
        badge(TextStyle.Success) { +"Build 1.2.2-Beta" }
    }
}