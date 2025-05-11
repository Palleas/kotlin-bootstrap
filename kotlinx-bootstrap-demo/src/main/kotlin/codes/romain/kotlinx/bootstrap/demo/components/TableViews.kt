package codes.romain.kotlinx.bootstrap.demo.components

import codes.romain.bootstrap.kotlinx.html.TextStyle
import codes.romain.bootstrap.kotlinx.html.badge
import codes.romain.components.tableView
import codes.romain.kotlinx.bootstrap.demo.componentSection
import kotlinx.html.FlowContent
import kotlinx.html.a

data class Student(
    val id: Int,
    val fullName: String,
    val department: Department,
) {
    enum class Department {
        Engineering, Art, Marketing
    }
}

val students = listOf(
    Student(1, "Scott Scummers", Student.Department.Art),
    Student(2, "Joanna Cargill", Student.Department.Engineering),
    Student(3, "Ororo Munroe", Student.Department.Marketing),
    Student(4, "Emma Frost", Student.Department.Marketing),
    Student(5, "Erik Hallgrimsson", Student.Department.Art),
)

val studentTableView = tableView<Student> {
    column("ID") { +it.id.toString() }
    textColumn("Name", Student::fullName)
    column("Department") { badge(TextStyle.Info) { +it.department.name } }

    actions {
        a(href = "/students/${it.id}") { +"View Details" }
    }
}

fun FlowContent.tableViews() {
    componentSection(
        title = "Table Views",
        url = null,
        rawCode = """
        data class Student(
            val id: Int,
            val fullName: String,
            val department: Department,
        ) {
            enum class Department {
                Engineering, Art, Marketing
            }
        }
        
        val students = listOf(
            // list of students...
        )
        
        val tableView = tableView<Student> {
            column("ID") { +it.id.toString() }
            textColumn("Name", Student::fullName)
            column("Department") { badge(TextStyle.Info) { +it.department.name } }
        
            actions {
                a(href = "/students/${"$"}{it.id}") { +"View Details" }
            }
        }
                """.trimIndent()
    ) {
        with(studentTableView) { render(students) }
    }
}