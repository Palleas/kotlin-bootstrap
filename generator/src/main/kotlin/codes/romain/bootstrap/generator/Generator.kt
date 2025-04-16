package codes.romain.bootstrap.generator

import com.squareup.kotlinpoet.*
import kotlinx.serialization.json.Json
import kotlin.io.path.Path


val type = ClassName("codes.romain.bootstrap.icons", "BootstrapIcon")

fun bootstrapIconType(name: String) = PropertySpec.builder(generatePropertyName(name), type)
    .initializer("%T(%S)", type, name)
    .build()

fun loadIcons() = object {}.javaClass.classLoader.getResourceAsStream("bootstrap-icons.json")
    ?.readAllBytes()
    ?.let { String(it) }
    ?.let { Json.Default.decodeFromString<List<String>>(it).map { it.split(".").first() } }
    ?: throw IllegalStateException("Unable to read file with list of icons")



fun main() {
    val iconList = loadIcons()

    val file = FileSpec
        .builder(
            packageName = "codes.romain.bootstrap.icons",
            fileName = "BootstrapIcon"
        )
        .addType(
            TypeSpec.classBuilder("BootstrapIcon")
                .addModifiers(KModifier.DATA)
                .primaryConstructor(
                    FunSpec.constructorBuilder().addParameter("value", String::class).build()
                )
                .addProperty(PropertySpec.builder("value", String::class).initializer("value").build())
                .build()
        )
        .addType(
            TypeSpec.companionObjectBuilder()
                .apply {
                    iconList.forEach {
                        addProperty(bootstrapIconType(it))
                    }
                }
                .build()
        )
        .build()

    val targetFile = Path("bootstrap-icons")
    file.writeTo(targetFile)
}

