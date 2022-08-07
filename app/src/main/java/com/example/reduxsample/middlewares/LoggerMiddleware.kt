package com.example.reduxsample.middlewares

import android.util.Log
import com.example.reduxsample.core.ActionType
import com.example.reduxsample.core.MiddlewareType
import com.example.reduxsample.core.StateType
import io.reactivex.Single

class LoggerMiddleware : MiddlewareType {
    override fun before(state: StateType, action: ActionType): Single<ActionType> {
        Log.d("ReduxLit", "Before dispatching: ${action::class.java.simpleName}")
        return Single.just(action)
    }

    override fun after(state: StateType, action: ActionType): Single<ActionType> {
        Log.d("ReduxKit", "After dispatching: ${action::class.simpleName}")
        return Single.just(action)
    }
}