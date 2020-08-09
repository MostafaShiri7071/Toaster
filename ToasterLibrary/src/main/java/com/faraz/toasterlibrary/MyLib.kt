package com.faraz.toasterlibrary

import android.app.Application
import com.faraz.toasterlibrary.di.apiModule
import com.faraz.toasterlibrary.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyLib:Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyLib)
            androidLogger(Level.ERROR)
            modules(listOf(netModule, apiModule))
        }
    }
}