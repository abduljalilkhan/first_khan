package com.example.githubmvvm

import android.util.Log

/**
 * Created by Emergentsoft on 11/2/2017.
 */
object LogCalls_Debug {
    const val TAG = "json"
    fun d(name: String?, s: String?) {
        s?.let { Log.d(name, it) }
    }
}
