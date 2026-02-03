package com.example.jetpackcomponent.activity.lifecycleObserver

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MainLifecycleObserver : DefaultLifecycleObserver{
    private val TAG = "Lifecycle"

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "ON_CREATE: 3")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "ON_START: 3")
        super.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "ON_RESUME")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "ON_PAUSE")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "ON_STOP")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "ON_DESTROY")
    }
}