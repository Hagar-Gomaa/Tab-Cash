package com.example.tabcash

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.tabcash.base.BaseActivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
    }
}