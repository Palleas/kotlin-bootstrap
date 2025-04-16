package codes.romain.bootstrap.generator

import com.squareup.kotlinpoet.*

val type = ClassName("codes.romain.bootstrap.icons", "BootstrapIcon")

fun bootstrapIconType(name: String) = PropertySpec.builder(name, type)
    .initializer("%T(%S)", type, name)
    .build()

val iconList = listOf(
    "fullscreen",
    "optical-audio",
    "person-square",
    "receipt-cutoff",
    "envelope-arrow-up",
    "symmetry-vertical",
    "lamp-fill",
    "brightness-alt-low",
    "box-arrow-left",
    "shift",
    "telephone-forward",
    "person-gear",
    "floppy",
    "crosshair",
    "calendar3-range-fill",
    "sticky-fill",
    "envelope-paper-heart",
    "file-play",
    "file-font",
    "mouse2",
    "9-square",
    "ear-fill",
    "pen-fill",
    "disc",
    "filetype-json",
    "house-add",
    "caret-down-square",
    "file-easel-fill",
    "7-circle-fill",
    "router",
    "router-fill",
    "calendar3-range",
    "egg",
    "sort-down-alt",
    "chat-quote-fill",
    "record-fill",
    "arrow-return-right",
    "text-indent-left",
    "cloud-drizzle-fill",
    "google",
)

fun main() {
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
                .addProperty(bootstrapIconType("phone"))
                .build()
        )
        .build()

    file.writeTo(System.out)
}

