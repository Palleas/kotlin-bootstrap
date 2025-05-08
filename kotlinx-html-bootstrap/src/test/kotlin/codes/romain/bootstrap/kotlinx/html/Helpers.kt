package codes.romain.bootstrap.kotlinx.html

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.stream.appendHTML

fun getContent(block: FlowContent.() -> Unit) = buildString {
    appendHTML(true).div {
        block()
    }
}
