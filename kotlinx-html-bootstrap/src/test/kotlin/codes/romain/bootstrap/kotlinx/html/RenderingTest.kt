package codes.romain.bootstrap.kotlinx.html

import codes.romain.bootstrap.icons.BootstrapIcon
import com.diffplug.selfie.coroutines.expectSelfie
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.shouldBe
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p
import kotlinx.html.span
import kotlinx.html.stream.appendHTML

class RenderingTest : FunSpec({
    context("Icons") {
        test("Regular Icon") {
            expectSelfie(getContent { icon(BootstrapIcon.AirplaneEnginesFill) }).toMatchDisk()
        }

        test("Icon with content") {
            expectSelfie(getContent { icon(BootstrapIcon.AirplaneEnginesFill) {
                span { +"Additional content" }
            } }).toMatchDisk()
        }

    }

    context("Alerts") {
        test("Simple alert") {
            expectSelfie(getContent { alert(AlertType.Info) { +"This is an alert!" } }).toMatchDisk()
        }

        test("Alert with heading and link") {
            expectSelfie(getContent {
                alert(AlertType.Info) {
                    h1 {
                        alertHeading()
                        +"Alert Title"
                    }

                    p {
                        +"Alert content"
                        a("/") {
                            alertLink()
                            +"Take Me Home"
                        }
                    }
                }
            }).toMatchDisk()
        }
    }
})


