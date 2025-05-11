package codes.romain.components

import kotlinx.html.FlowContent
import kotlinx.html.TD
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.tfoot
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr

fun <T> tableView(builder: TableViewBuilder<T>.() -> Unit) = TableViewBuilder<T>()
    .apply(builder)
    .build()

data class Column<T>(
    val title: String,
    val value: TD.(T) -> Unit,
)

class TableViewBuilder<T> {
    private val columns = mutableListOf<Column<T>>()
    private var actionCell: TD.(T) -> Unit = {}

    fun column(title: String, value: TD.(T) -> Unit) {
        columns.add(Column(title, value))
    }

    fun textColumn(title: String, value: (T) -> String) {
        column(title) { +value(it) }
    }

    fun actions(block: TD.(T) -> Unit) {
        this.actionCell = block
    }

    fun build() = TableView(columns, actionCell)
}

data class TableView<T>(
    private val columns: List<Column<T>>,
    private val action: TD.(T) -> Unit,
) {
    fun FlowContent.render(items: List<T>) {
        table(classes = "table table-striped") {
            thead {
                tr(classes = "align-middle") {
                    columns.forEach {
                        th {
                            +it.title
                        }
                    }

                    th { +"Actions" }
                }
            }

            tbody {
                items.forEach { item ->
                    tr(classes = "align-middle") {
                        columns.forEach { column ->
                            td {
                                column.value.invoke(this, item)
                            }
                        }

                        td {
                            action.invoke(this, item)
                        }
                    }
                }
            }

            tfoot {
                tr {
                    td {
                        colSpan = (columns.count() + 1).toString()
                        +"${items.count()} items"
                    }
                }
            }
        }
    }
}