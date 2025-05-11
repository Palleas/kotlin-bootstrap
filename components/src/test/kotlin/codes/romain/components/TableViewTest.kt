package codes.romain.components

import codes.romain.bootstrap.kotlinx.html.TextStyle
import codes.romain.bootstrap.kotlinx.html.badge
import com.diffplug.selfie.coroutines.expectSelfie
import io.kotest.core.spec.style.FunSpec
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.stream.appendHTML

private data class Student(
    val id: Int,
    val fullName: String,
    val department: Department,
) {
    enum class Department {
        Engineering, Art, Marketing
    }
}

class TableViewBuilderTest : FunSpec({
    val students = listOf(
        Student(1, "Scott Scummers", Student.Department.Art),
        Student(2, "Joanna Cargill", Student.Department.Engineering),
        Student(3, "Ororo Munroe", Student.Department.Marketing),
        Student(4, "Emma Frost", Student.Department.Marketing),
        Student(5, "Erik Hallgrimsson", Student.Department.Art),
    )

    test("render list of students") {
        val tableView = tableView<Student> {
            column("ID") { +it.id.toString() }
            textColumn("Name", Student::fullName)
            column("Department") { badge(TextStyle.Info) { +it.department.name } }

            actions {
                a(href = "/students/${it.id}") { +"View Details" }
            }
        }

        expectSelfie(getTableViewContent(tableView, students)).toMatchDisk()
    }
})


fun <T> getTableViewContent(form: TableView<T>, items: List<T>) = buildString {
    appendHTML().div {
        with(form) {
            render(items)
        }
    }
}