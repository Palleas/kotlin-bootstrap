package codes.romain.bootstrap.kotlinx.html

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.role

fun H1.alertHeading() { classes += "alert-heading" }
fun H2.alertHeading() { classes += "alert-heading" }
fun H3.alertHeading() { classes += "alert-heading" }
fun H4.alertHeading() { classes += "alert-heading" }
fun H5.alertHeading() { classes += "alert-heading" }
fun H6.alertHeading() { classes += "alert-heading" }

fun A.alertLink() { classes += "alert-link" }

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

/**
 * Renders an alert
 * @link https://getbootstrap.com/docs/5.3/components/alerts/#link-color
 */
fun FlowContent.alert(type: AlertType, content: DIV.() -> Unit) {
    div(classes = "alert alert-${type.className}") {
        role = "alert"

        content()
    }
}