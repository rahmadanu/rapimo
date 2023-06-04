package com.hepipat.rapimo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RapimoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}