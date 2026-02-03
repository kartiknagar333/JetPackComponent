package com.example.jetpackcomponent.activity.lifecycleObserver

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class LifecycleAwareObserver<T>(
    private val lifecycle: Lifecycle,
    private val liveData: LiveData<T>,
    private val observer: Observer<T>
) : DefaultLifecycleObserver {
    
    init {
        lifecycle.addObserver(this)
    }
    
    override fun onStart(owner: LifecycleOwner) {
        liveData.observeForever(observer)
    }
    
    override fun onStop(owner: LifecycleOwner) {
        liveData.removeObserver(observer)
    }
    
    override fun onDestroy(owner: LifecycleOwner) {
        lifecycle.removeObserver(this)
    }
}

