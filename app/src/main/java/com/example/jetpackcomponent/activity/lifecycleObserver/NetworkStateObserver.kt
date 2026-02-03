package com.example.jetpackcomponent.activity.lifecycleObserver

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class NetworkStateObserver(
    private val lifecycle: Lifecycle,
    private val connectivityManager: ConnectivityManager
) : LifecycleEventObserver {
    
    private var networkCallback: ConnectivityManager.NetworkCallback? = null
    
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> registerNetworkCallback()
            Lifecycle.Event.ON_STOP -> unregisterNetworkCallback()
            else -> { /* Ignore other events */ }
        }
    }
    
    private fun registerNetworkCallback() {
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                Log.d("NetworkStateObserver", "onAvailable: Network available")
            }
            
            override fun onLost(network: Network) {
                Log.d("NetworkStateObserver", "onAvailable: Network lost")
            }
        }
        
        networkCallback?.let {
            connectivityManager.registerNetworkCallback(networkRequest, it)
        }
    }
    
    private fun unregisterNetworkCallback() {
        networkCallback?.let {
            connectivityManager.unregisterNetworkCallback(it)
            networkCallback = null
        }
    }
}