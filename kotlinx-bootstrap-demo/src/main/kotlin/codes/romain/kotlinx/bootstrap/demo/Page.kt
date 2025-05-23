package codes.romain.kotlinx.bootstrap.demo

import kotlinx.html.FlowContent
import kotlinx.html.ScriptCrossorigin
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.stream.appendHTML
import kotlinx.html.title
import kotlinx.html.unsafe

class Page(private val pageTitle: String, val content: FlowContent.() -> Unit) {

    fun render(): String = buildString {
        appendHTML().html {
            head {
                title { +pageTitle }
                meta("viewport", content = "width=device-width, initial-scale=1.0")
                link("https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css", rel = "stylesheet") {
                    integrity = "sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
                    attributes["crossorigin"] = "anonymous"
                }

                link(
                    "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.12.1/font/bootstrap-icons.min.css",
                    rel = "stylesheet"
                )

                link(href = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/default.min.css", rel = "stylesheet")
            }

            body {
                div("container mb-2") {
                    content()
                }

                footer("text-center p-4") {
                    +"Made in Vancouver by "
                    a(href = "https://romain.codes") { +"Romain Pouclet." }

                    +" Generated using "
                    a("https://github.com/Kotlin/kotlinx.html") { +"kotlinx.html" }
                    +" and this library."
                }



                script(src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js") {
                    crossorigin = ScriptCrossorigin.anonymous
                    integrity = "sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
                }
                script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js") {  }
                script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/languages/kotlin.min.js") {  }
                script {
                    unsafe {
                        +"hljs.highlightAll();"
                    }
                }
            }
        }
    }
}