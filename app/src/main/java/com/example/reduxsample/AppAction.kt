package com.example.reduxsample

import com.example.reduxsample.core.ActionType

sealed class AppAction : ActionType {
    data class RefreshTodos(val todos: List<Todo>) : AppAction()
    data class AddTodo(val todo: Todo) : AppAction()
}