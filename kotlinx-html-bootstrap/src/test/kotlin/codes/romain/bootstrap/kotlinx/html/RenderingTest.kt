package codes.romain.bootstrap.kotlinx.html

import codes.romain.bootstrap.icons.BootstrapIcon
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.shouldBe
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.stream.appendHTML

class RenderingTest : FunSpec({
    context("Bootstrap Icons") {
        buildString {
            appendHTML(false).div {
                icon(BootstrapIcon.AirplaneEnginesFill)
            }
        } shouldBe """<div><i class="bi bi-airplane-engines-fill"></i></div>"""
    }
})

