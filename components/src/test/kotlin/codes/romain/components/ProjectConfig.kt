package codes.romain.components

import com.diffplug.selfie.kotest.SelfieExtension
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension

class ProjectConfig: AbstractProjectConfig() {
    override fun extensions(): List<Extension> = listOf(SelfieExtension(this))
}