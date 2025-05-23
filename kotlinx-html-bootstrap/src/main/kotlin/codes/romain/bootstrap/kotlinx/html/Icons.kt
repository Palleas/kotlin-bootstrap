package codes.romain.bootstrap.kotlinx.html

import codes.romain.bootstrap.icons.BootstrapIcon
import kotlinx.html.FlowContent
import kotlinx.html.I
import kotlinx.html.i

fun FlowContent.icon(iconName: BootstrapIcon, block: I.() -> Unit = {}) {
    i("bi bi-${iconName.value}", block = block)
}
