package com.example.jetpackcomponent.activity.lifecycleObserver

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MainLifecycleObserver : DefaultLifecycleObserver{

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        println("ON_CREATE - 3")
    }

    override fun onStart(owner: LifecycleOwner) {
        println("ON_START - 3")
        super.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        println("ON_RESUME")
    }

    override fun onPause(owner: LifecycleOwner) {
        println("ON_PAUSE")
    }

    override fun onStop(owner: LifecycleOwner) {
        println("ON_STOP")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        println("ON_DESTROY")
    }
}