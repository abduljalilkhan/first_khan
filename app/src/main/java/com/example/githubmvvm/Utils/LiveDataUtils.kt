package com.example.githubmvvm.Utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class LiveDataUtils {

    fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        observe(lifecycleOwner, object : Observer<T> {
            override fun onChanged(value: T) {
                observer.onChanged(value)
                removeObserver(this)
            }
        })
    }

    fun <T> LiveData<T>.observeOnceWithLifeCycle(liveData: LiveData<T>, lifecycleOwner: LifecycleOwner?, observer: Observer<T>) {
        liveData.observe(lifecycleOwner!!) { value ->
            observer.onChanged(value)
            liveData.removeObserver(observer)
        }
    }
}
