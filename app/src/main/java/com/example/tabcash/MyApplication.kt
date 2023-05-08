package com.example.tabcash

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
    }
}