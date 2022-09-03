package com.example.reduxsample

import com.example.reduxsample.core.StateType

data class AppState(
    val todos: List<Todo> = emptyList()
) : StateType