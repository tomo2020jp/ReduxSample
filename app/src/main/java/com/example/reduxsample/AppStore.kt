package com.example.reduxsample

import com.example.reduxsample.core.ActionType
import com.example.reduxsample.core.MiddlewareType
import com.example.reduxsample.core.StoreType
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class AppStore(
    private val initialState: AppState = AppState()
) : StoreType<AppState> {

    private val state = BehaviorRelay.createDefault(initialState)
    private val middlewares = mutableListOf<MiddlewareType>()

    override fun dispatch(action: ActionType) {
        state.value?.let { currentState ->
            middlewares.forEach { it.before(currentState, action) }
            val nextState = AppReducer.reduce(currentState, action as AppAction)
            state.accept(nextState)
            middlewares.forEach { it.after(currentState, action) }
        }
    }

    override fun observable(): Observable<AppState> {
        return state.observeOn(AndroidSchedulers.mainThread())
    }

    override fun addMiddleware(middleware: MiddlewareType) {
        middlewares.add(middleware)
    }

    override fun removeMiddleware(middleware: MiddlewareType) {
        middlewares.remove(middleware)
    }

}