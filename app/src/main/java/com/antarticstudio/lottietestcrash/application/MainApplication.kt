package com.antarticstudio.lottietestcrash.application

import android.app.Application
import com.antarticstudio.lottietestcrash.dependencies.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    companion object {
        private lateinit var INSTANCE: MainApplication

        fun app(): MainApplication {
            return INSTANCE
        }

    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            androidFileProperties()
            modules(appComponent)
        }
    }
}
