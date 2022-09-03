package com.example.reduxsample

import com.example.reduxsample.core.ReducerType

object AppReducer : ReducerType<AppState, AppAction> {

    override fun reduce(state: AppState, action: AppAction): AppState {
        return when (action) {
            is AppAction.RefreshTodos -> {
                state.copy(todos = action.todos)
            }
            is AppAction.AddTodo -> {
                state.copy(todos = state.todos.plus(action.todo))
            }
        }
    }

}