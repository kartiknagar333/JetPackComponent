package com.example.jetpackcomponent.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.activity.lifecycleObserver.MainLifecycleEventObserver
import com.example.jetpackcomponent.activity.lifecycleObserver.MainLifecycleObserver
import com.example.jetpackcomponent.activity.lifecycleObserver.NetworkStateObserver

class MainActivity : AppCompatActivity() {

    private val TAG = "Lifecycle"

    private lateinit var mainLifecycleObserver: MainLifecycleObserver
    private lateinit var mainLifecycleEventObserver: MainLifecycleEventObserver
    private lateinit var networkStateObserver: NetworkStateObserver
    private val observers = mutableListOf<LifecycleObserver>()

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: 1")
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: 2")

        setContentView(R.layout.activity_main)

        mainLifecycleObserver = MainLifecycleObserver()
        mainLifecycleEventObserver = MainLifecycleEventObserver()
        networkStateObserver = NetworkStateObserver(
            lifecycle = lifecycle,
            connectivityManager =   (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        )

        // Add to list for tracking
        observers.add(mainLifecycleObserver)
        observers.add(mainLifecycleEventObserver)
        observers.add(networkStateObserver)

        // Add all observers to lifecycle
        observers.forEach { lifecycle.addObserver(it) }


    }

    override fun onStart() {
        Log.d(TAG, "onStart: 1")
        super.onStart()
        Log.d(TAG, "onStart: 2")
    }

    override fun onDestroy() {
        // Remove all observers safely
        removeAllObservers()
        super.onDestroy()
        Log.d(TAG, "onDestroy: All observers removed")
    }


    private fun removeAllObservers() {
        observers.forEach { observer ->
            try {
                lifecycle.removeObserver(observer)
                Log.d(TAG, "Removed observer: ${observer.javaClass.simpleName}")
            } catch (e: Exception) {
                Log.e(TAG, "Error removing observer: ${observer.javaClass.simpleName}", e)
            }
        }
        observers.clear()
    }

}