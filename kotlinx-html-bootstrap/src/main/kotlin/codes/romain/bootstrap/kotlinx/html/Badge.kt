package codes.romain.bootstrap.kotlinx.html

import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.classes
import kotlinx.html.span

enum class TextStyle(val className: String) {
    Primary("text-bg-primary"),
    Secondary("text-bg-secondary"),
    Success("text-bg-success"),
    Danger("text-bg-danger"),
    Warning("text-bg-warning"),
    Info("text-bg-info"),
    Light("text-bg-light"),
    Dark("text-bg-dark")
}

fun SPAN.roundedPill() {
    classes += "rounded-pill"
}

fun FlowContent.badge(style: TextStyle, content: SPAN.() -> Unit) {
    span(classes = "badge ${style.className}") {
        content()
    }
}