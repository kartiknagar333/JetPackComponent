package com.example.jetpackcomponent.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.activity.lifecycleObserver.MainLifecycleEventObserver
import com.example.jetpackcomponent.activity.lifecycleObserver.MainLifecycleObserver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        println("ON_CREATE - 1")
        super.onCreate(savedInstanceState)
        println("ON_CREATE - 2")

        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MainLifecycleObserver())
        lifecycle.addObserver(MainLifecycleEventObserver())

    }

    override fun onStart() {
        println("ON_START - 1")
        super.onStart()
        println("ON_START - 2")

    }

}