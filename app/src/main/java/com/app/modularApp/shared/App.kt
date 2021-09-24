package com.app.modularApp.shared

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.StringRes

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        @JvmStatic
        fun string(@StringRes idRes: Int): String {
            //TODO: check late Initialize
            return context.getString(idRes)
        }
    }

}