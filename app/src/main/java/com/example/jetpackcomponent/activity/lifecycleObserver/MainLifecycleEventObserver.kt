package com.example.jetpackcomponent.activity.lifecycleObserver

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MainLifecycleEventObserver: LifecycleEventObserver {
    override fun onStateChanged(
        source: LifecycleOwner,
        event: Lifecycle.Event
    ) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> println("ON_CREATE - 4")
            Lifecycle.Event.ON_START -> println("ON_START - 4")
            Lifecycle.Event.ON_RESUME -> println("ON_RESUME")
            Lifecycle.Event.ON_PAUSE -> println("ON_PAUSE")
            Lifecycle.Event.ON_STOP -> println("ON_STOP")
            Lifecycle.Event.ON_DESTROY -> println("ON_DESTROY")
            Lifecycle.Event.ON_ANY -> println("ON_ANY")
        }
    }

}