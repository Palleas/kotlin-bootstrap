package codes.romain.bootstrap.kotlinx.html

import codes.romain.bootstrap.icons.BootstrapIcon
import com.diffplug.selfie.coroutines.expectSelfie
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.shouldBe
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.stream.appendHTML

class RenderingTest : FunSpec({
    test("Icons") {
        expectSelfie(getContent { icon(BootstrapIcon.AirplaneEnginesFill) }).toMatchDisk()
    }

    test("Alerts") {
        expectSelfie(getContent { alert(AlertType.Info) { +"This is an alert!"} }).toMatchDisk()
    }
})


