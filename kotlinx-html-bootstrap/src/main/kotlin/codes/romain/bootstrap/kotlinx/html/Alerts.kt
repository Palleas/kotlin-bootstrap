package codes.romain.bootstrap.kotlinx.html

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.role

enum class AlertType(val className: String) {
    Primary(className = "primary"),
    Secondary(className = "secondary"),
    Success(className = "success"),
    Danger(className = "danger"),
    Warning(className = "warning"),
    Info(className = "info"),
    Light(className = "light"),
    Dark(className = "dark"),
}

fun FlowContent.alert(type: AlertType, content: DIV.() -> Unit) {
    div(classes = "alert alert-${type.className}") {
        role = "alert"

        content()
    }
}