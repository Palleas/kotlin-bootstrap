package codes.romain.bootstrap.generator

import io.kotest.core.names.TestNameCase
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

private data class NamingTestCase(val iconName: String, val expectedPropertyName: String) : WithDataTestName {
    override fun dataTestName(): String = "$iconName should yield property name $expectedPropertyName"
}

class FormattersTest : FunSpec({

    context("generating property name from icon name") {
        withData(
            listOf(
                NamingTestCase("9-square", "NineSquare"),
                NamingTestCase("exclamation-triangle-fill", "ExclamationTriangleFill")
            )
        ) {
            generatePropertyName(it.iconName) shouldBe it.expectedPropertyName
        }
    }
})
