package com.example.reduxsample

import java.util.*

data class Todo(
    val title: String,
    val data: Date,
    val isCompleted: Boolean
) {
    companion object {
        fun createSampleTodos(): List<Todo> {
            return listOf(
                Todo(title = "\uD83D\uDCDD AdventCalendarを書く", Date(), false)
            )
        }
    }
}
