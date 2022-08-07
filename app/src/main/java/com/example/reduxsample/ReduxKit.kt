package com.example.reduxsample

import android.app.Application
import com.example.reduxsample.middlewares.LoggerMiddleware

class ReduxKit:Application() {
    val appStore = AppStore()

    override fun onCreate() {
        super.onCreate()
        appStore.addMiddleware(LoggerMiddleware())
    }
}