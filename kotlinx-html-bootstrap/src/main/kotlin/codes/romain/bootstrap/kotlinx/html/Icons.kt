package codes.romain.bootstrap.kotlinx.html

import codes.romain.bootstrap.icons.BootstrapIcon
import kotlinx.html.FlowContent
import kotlinx.html.i

fun FlowContent.icon(iconName: BootstrapIcon) {
    i("bi bi-${iconName.value}")
}
